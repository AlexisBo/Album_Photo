package controleur;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele_DAO.UtilisateurDAO;
import modele_entity.Utilisateur;

public class InscriptionUtilisateur extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UtilisateurDAO utilisateurDAO;

	public void init() {
		utilisateurDAO = new UtilisateurDAO();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String operation = request.getParameter("operation");
		//String chemin = "/Album_Photo/Projet/index.html";
		
		// Gestion de la connexion
		if (operation.equals("inscription")) {
			String pseudo = request.getParameter("pseudo");
			String email = request.getParameter("email");
			String mdp = request.getParameter("mdp");
			String telephone = request.getParameter("telephone");
			// Date dateNaissance = request.getParameter("dateNaissance");
			Utilisateur u = utilisateurDAO.sInscrire(pseudo, email, mdp, telephone/* , dateNaissance */);

			HttpSession session = request.getSession();

			if (u != null) {
				session.setAttribute("utilisateur", u);
			}
			//chemin = "/Album_Photo/Projet/WebContent/www/album_listing.jsp";
		}
		
		if (operation.equals("test")) {
			Utilisateur u = (Utilisateur) utilisateurDAO.getByPseudo("admin");

			HttpSession session = request.getSession();

			if (u != null) {
				session.setAttribute("utilisateur", u);
			}
			
			//chemin = "/Album_Photo/Projet/WebContent/www/connexion_test.jsp";
		}

		//this.getServletContext().getRequestDispatcher(chemin).forward(request, response);
	}
}
