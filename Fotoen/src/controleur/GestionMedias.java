package controleur;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import modele_DAO.AlbumDAO;
import modele_DAO.GenericDAO;
import modele_DAO.MediaDAO;
import modele_DAO.UtilisateurDAO;

@WebServlet("/ConsulterAlbum")
public class GestionMedias extends HttpServlet {

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

	// traite les différentes actions exercées sur la vue (suppréssion, ajout,
	// consultation, visualisation, ...)
	public void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String chemin = "/www/error.jsp";
		String[] splits = request.getServletPath().split("/");
		String operation = splits[splits.length - 1];

		// Ajout d'une photo
		if (operation.equals("mediaAjout")) {
			Utilisateur utilisateur = utilisateurDAO
					.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur")));

			Album album = albumDAO.getAlbumCurrent(utilisateur.getId());

			String path = GenericDAO.MEDIAS_CHEMIN_ABSOLUE + "melvin" + "\\" + "Courant" + "\\";

			Media media = new Media(path, request.getParameter("description"), utilisateur.getId(), album.getId());

			if (sauvegarde && mediaDAO.insert(media) != 0) {
				request.setAttribute("utilisateur", utilisateur);
				chemin = "/www/media.jsp";
				System.err.println("mediaAjout: Media " + media.getLien() + " ajouté");
			} else {
				request.setAttribute("utilisateur", null);
				request.setAttribute("erreur", "Media non valide");
			}
		}

		// Suppression d'une photo
		if (operation.equals("mediaSuppression")) {

			if (mediaDAO.supprimer(request.getParameter("media")) != 0) {
				chemin = "/www/album_listing.jsp";
				System.err.println("mediaSuppression " + request.getParameter("mediaSuppression") + " ajoutÃ©");
			} else {
				request.setAttribute("erreur", "MÃ©dia non supprimÃ©");
			}

			System.err.println("mediaSuppression data value" + request.getParameter("data-value") + " ajoutÃ©");
		}

		this.getServletContext().getRequestDispatcher(chemin).forward(request, response);
	}
}