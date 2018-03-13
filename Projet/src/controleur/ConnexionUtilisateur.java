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
		//if (operation.equals("connexion")) {
			Utilisateur u = utilisateurDAO.seConnecter("admin@fotoen.fr", "admin");

			System.err.println("Utilisateur récupéré");

			System.err.println(u);
			
			System.err.println(u.getPseudo());
			
			if (u != null) {
				request.setAttribute("utilisateur", u);
			} else {
				request.setAttribute("utilisateur", null);
			}

			this.getServletContext().getRequestDispatcher("/www/album_listing.jsp").forward(request, response);
		//}
	}
}
