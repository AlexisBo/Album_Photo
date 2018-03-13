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
public class GestionUtilisateur extends HttpServlet {

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
		String chemin = "/www/accueil.jsp";

		// Gestion de l'inscription
		if (operation.equals("inscription")) {
			Utilisateur utilisateur = new Utilisateur(request.getParameter("pseudo"), request.getParameter("email"),
					request.getParameter("mdp"), request.getParameter("telephone"), null);

			// String[] splitDate = request.getParameter("dateNaissance").split("-");
			if (utilisateurDAO.sInscrire(utilisateur) != 0) {
				request.setAttribute("utilisateur", utilisateur);
				chemin = "/www/album_listing.jsp";
			} else {
				request.setAttribute("utilisateur", null);
				request.setAttribute("erreur", "Inscription non valide");
			}

			System.err.println("Inscription: Utilisateur " + utilisateur.getPseudo()  + " récupéré");
		}

		// Gestion de la connexion
		if (operation.equals("connexion")) {
			Utilisateur utilisateur = utilisateurDAO.seConnecter(request.getParameter("email"), request.getParameter("mdp"));

			if (utilisateur != null) {
				request.setAttribute("utilisateur", utilisateur);
				chemin = "/www/album_listing.jsp";
			} else {
				request.setAttribute("utilisateur", null);
				request.setAttribute("erreur", "Inscription non valide");
			}

			System.err.println("Connexion: Utilisateur " + utilisateur.getPseudo()  + " récupéré");
		}

		this.getServletContext().getRequestDispatcher(chemin).forward(request, response);
	}
}
