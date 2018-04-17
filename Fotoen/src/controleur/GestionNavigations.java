package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele_DAO.AlbumDAO;
import modele_DAO.MediaDAO;
import modele_DAO.UtilisateurDAO;
import modele_entity.Media;
import modele_entity.Utilisateur;

@WebServlet("/GestionNavigations")
public class GestionNavigations extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UtilisateurDAO utilisateurDAO;
	AlbumDAO albumDAO;
	MediaDAO mediaDAO;

	public void init() {
		utilisateurDAO = new UtilisateurDAO();
		albumDAO = new AlbumDAO();
		mediaDAO = new MediaDAO();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	// traite les différentes actions exercées sur la vue (suppréssion, ajout, ...)
	public void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String chemin = "/www/error.jsp";
		String[] splits = request.getServletPath().split("/");
		String operation = splits[splits.length - 1];

		if (operation.equals("accueil")) {
			request.setAttribute("utilisateur",
					utilisateurDAO.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur"))));
			chemin = "/www/accueil.jsp";
			System.err.println("consulterAccueil: go accueil.jsp");
		}

		if (operation.equals("profil")) {
			request.setAttribute("utilisateur",
					utilisateurDAO.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur"))));
			chemin = "/www/profil.jsp";
			System.err.println("consulterProfil: go profil.jsp");
		}

		if (operation.equals("consulterAlbums")) {
			request.setAttribute("utilisateur",
					utilisateurDAO.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur"))));
			chemin = "/www/album_listing.jsp";
			System.err.println("consulterAlbums: go album_listing.jsp");
		}

		if (operation.equals("consulterAlbum")) {
			request.setAttribute("utilisateur",
					utilisateurDAO.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur"))));
			request.setAttribute("album", albumDAO.getAlbumById(Integer.parseInt(request.getParameter("album"))));
			chemin = "/www/album.jsp";
			System.err.println("consulterAlbum: go album.jsp");
		}

		if (operation.equals("consulterMedia")) {
			Utilisateur utilisateur = utilisateurDAO.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur")));
			request.setAttribute("utilisateur", utilisateur);
			Media media = mediaDAO.getMediaById(Integer.parseInt(request.getParameter("media")));

			if (media != null) {
				request.setAttribute("media", media);
				chemin = "/www/media.jsp";
				System.err.println("consulterMedia: go media.jsp");
			} else {
				request.setAttribute("utilisateur", utilisateur);
				request.setAttribute("erreur", "Media non consultable");
			}
		}

		this.getServletContext().getRequestDispatcher(chemin).forward(request, response);
	}
}
