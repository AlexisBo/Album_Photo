package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele_DAO.UtilisateurDAO;
import modele_entity.Utilisateur;

@WebServlet("/ConnexionUtilisateur")
public class ConnexionUtilisateur extends HttpServlet {

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

	public void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("operation");

		// Gestion de la connexion
		if (operation.equals("connexion")) {
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			Utilisateur u = utilisateurDAO.seConnecter(email, password);

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
