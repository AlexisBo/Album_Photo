package controleur;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele_DAO.AlbumDAO;
import modele_DAO.UtilisateurDAO;
import modele_entity.Album;
import modele_entity.Utilisateur;

@WebServlet("/GestionUtilisateur")
public class GestionUtilisateur extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UtilisateurDAO utilisateurDAO;
	AlbumDAO albumDAO;

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

		String chemin = "/www/error.jsp";
		String[] splits = request.getServletPath().split("/");
		String operation = splits[splits.length - 1];

		// Gestion de l'inscription
		if (operation.equals("inscription")) {
			String stringDate = request.getParameter("dateNaissance");
			String[] dates = null;
			if (stringDate.contains("-")) {
				dates = stringDate.split("-");
			} else if (stringDate.contains("/")) {
				dates = stringDate.split("/");
			}
			Date date = new Date((Integer.parseInt(dates[0]) - 1900), (Integer.parseInt(dates[1]) - 1), Integer.parseInt(dates[2]));

			Utilisateur utilisateur = new Utilisateur(request.getParameter("pseudo"), request.getParameter("email"),
					request.getParameter("mdp"), request.getParameter("telephone"), date);

			utilisateur = utilisateurDAO.sInscrire(utilisateur);
			if (utilisateur != null) {
				chemin = "/www/album_listing.jsp";
				utilisateur.insertAlbums();
				System.err.println("Inscription: Utilisateur " + utilisateur.getPseudo() + " inscrit");
			} else {
				request.setAttribute("erreur", "Inscription non valide");
			}
			request.setAttribute("utilisateur", utilisateur);
		}

		// Gestion de la connexion
		if (operation.equals("connexion")) {
			Utilisateur utilisateur = utilisateurDAO.seConnecter(request.getParameter("email"),
					request.getParameter("mdp"));

			if (utilisateur != null) {
				request.setAttribute("utilisateur", utilisateur);
				chemin = "/www/album_listing.jsp";
				System.err.println("Connexion: Utilisateur " + utilisateur.getPseudo() + " récupéré");
			} else {
				request.setAttribute("utilisateur", null);
				request.setAttribute("erreur", "Inscription non valide");
			}
		}

		this.getServletContext().getRequestDispatcher(chemin).forward(request, response);
	}
}
