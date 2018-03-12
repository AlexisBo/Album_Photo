package Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele_DAO.UtilisateurDAO;
import modele_entity.Utilisateur;

@WebServlet("/InscriptionUtilisateur")
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
			Utilisateur utilisateur = new Utilisateur("admin", "admin@fotoen.fr", "admin", "0120304050", null);

			//String[] splitDate = request.getParameter("dateNaissance").split("-");
			if(utilisateurDAO.sInscrire(utilisateur) != 0) {
				request.setAttribute("utilisateur", utilisateur);
			} else {
				request.setAttribute("utilisateur", null);
			}

//			HttpSession session = request.getSession();
//			
//			if (u != null) {
//				session.setAttribute("utilisateur", u);
//			}
			
	        this.getServletContext().getRequestDispatcher("/www/bonjour.jsp").forward(request, response);
	}
}
