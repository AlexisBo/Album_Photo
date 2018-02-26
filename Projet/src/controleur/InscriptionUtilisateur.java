package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele_DAO.UtilisateurDAO;
import modele_entity.Utilisateur;

//@WebServlet("/InscriptionUtilisateur")
public class InscriptionUtilisateur extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UtilisateurDAO utilisateurDAO;

	public void init() {
		utilisateurDAO = new UtilisateurDAO();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}
	
	public void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operation = request.getParameter("operation");

		// Gestion de la connexion
		if (operation.equals("inscription")) {
			String pseudo = request.getParameter("pseudo");
			String email = request.getParameter("email");
			String mdp = request.getParameter("mdp");
			String telephone = request.getParameter("telephone");
			//String[] splitDate = request.getParameter("dateNaissance").split("-");
			Utilisateur u = utilisateurDAO.sInscrire(pseudo, email, mdp, telephone/* , dateNaissance */);

			HttpSession session = request.getSession();
			
			if (u != null) {
				session.setAttribute("utilisateur", u);
			}

			System.err.println("before");
			
			this.getServletContext().getRequestDispatcher("/Projet/www/album_listing.jsp")
					.forward(request, response);
		}
	}
}
