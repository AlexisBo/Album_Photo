package controleur;

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

	public void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("operation");

		// Gestion de l'inscription
		if (operation.equals("inscription")) {
			Utilisateur utilisateur = new Utilisateur(request.getParameter("pseudo"), request.getParameter("email"),
					request.getParameter("mdp"), request.getParameter("telephone"), null);

			System.err.println("Utilisateur récupéré");

			// String[] splitDate = request.getParameter("dateNaissance").split("-");
			if (utilisateurDAO.sInscrire(utilisateur) != 0) {
				request.setAttribute("utilisateur", utilisateur);
			} else {
				request.setAttribute("utilisateur", null);
			}

			this.getServletContext().getRequestDispatcher("/www/album_listing.jsp").forward(request, response);
		}
	}
}
