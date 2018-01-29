package controleur;

import java.io.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele_DAO.GestionAlbum;

public class C_GestionAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UtilisateurDAO utilisateurDAO;
	MediaDAO mediaDAO;

	public void init() {
		utilisateurDAO = new UtilisateurDAO();
		mediaDAO = new MediaDAO();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("operation");

		// Gestion de la connexion
		if (operation.equals("seConnecter")) {
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			boolean ec = utilisateurDAO.seConnecter(login, pass);
			request.setAttribute("EtatConnexion", ec);
			RequestDispatcher dispatch = request
					.getRequestDispatcher("/www/Accueil.html");
			dispatch.forward(request, response);
		}

		// Rechercher media par dossier.
		if (operation.equals("rechercherMediaByFolder")) {
			String folderName = request.getParameter("folderName");
			List<Media> medias = mediaDAO.rechercherMediaByFolder(folderName);
			request.setAttribute("Medias", medias);
			RequestDispatcher dispatch = request
					.getRequestDispatcher("/www/.jsp");
			dispatch.forward(request, response);
		}

		// Mettre en ligne un media.
		if (operation.equals("ajouterMedia")) {
			String idMedia = request.getParameter("idMedia");
			/** ... **/
			String dossierParent = request.getParameter("dossierParent");
			Media media = mediaDAO.ajouterMedia(idMedia, ..., dossierParent);
			request.setAttribute("Media", media);
			RequestDispatcher dispatch = request
					.getRequestDispatcher("/www/.jsp");
			dispatch.forward(request, response);
		}

		// Retirer (supprimer) un media.
		if (operation.equals("retirerMedia")) {
			String idMedia = request.getParameter("idMedia");
			mediaDAO.retirerMedia(Integer.parseInt(idMedia));
			RequestDispatcher dispatch = request
					.getRequestDispatcher("/www/.jsp");
			dispatch.forward(request, response);
		}
	}
}