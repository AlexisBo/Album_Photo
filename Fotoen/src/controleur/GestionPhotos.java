package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele_DAO.AlbumDAO;
import modele_entity.Album;
import modele_DAO.MediaDAO;
import modele_entity.Media;
import modele_DAO.UtilisateurDAO;
import modele_entity.Utilisateur;

@WebServlet("/ConsulterAlbum")
public class GestionPhotos extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UtilisateurDAO utilisateurDAO;
	MediaDAO mediaDAO;

	public void init() {

		utilisateurDAO = new UtilisateurDAO();
		mediaDAO = new MediaDAO();

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

		// Ajout d'une photo
		if (operation.equals("photoAjout")) {
			System.err.println("Verification " + request.getParameter("idUtilisateur"));
			Media media = new Media(request.getParameter("lien"), request.getParameter("description"),
					Integer.parseInt(request.getParameter("idUtilisateur"), Integer.parseInt(request.getParameter("idAlbum"))), false, new Date(new java.util.Date().getTime()));

			if (mediaDAO.insert(media) != 0) {
				Utilisateur utilisateur = utilisateurDAO.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur")));
				
				request.setAttribute("utilisateur", utilisateur);
				chemin = "/www/album_listing.jsp";
				System.err.println("AjoutAlbum: Album " + media.getLien() + " ajouté");
			} else {
				request.setAttribute("utilisateur", null);
				request.setAttribute("erreur", "Album non valide");
			}
		}

		//Visualisation d'une photo
		if (operation.equals("photoVisualiser")) {
			String media = request.getParameter("media");
			
			Album m = mediaDAO.visualiser(media);

			if (m != null) {
				request.setAttribute("media", m);
			} else {
				request.setAttribute("media", null);
			}
		}

		//Suppression d'une photo
		if (operation.equals("photoSuppression")) {

			if (mediaDAO.supprimer(request.getParameter("media")) != 0) {				
				chemin = "/www/album_listing.jsp";
				System.err.println("mediaSuppression " + request.getParameter("mediaSuppression") + " ajouté");
			} else {
				request.setAttribute("erreur", "Média non supprimé");
			}
			
			System.err.println("mediaSuppression data value" + request.getParameter("data-value") + " ajouté");
		}
		this.getServletContext().getRequestDispatcher("/www/album.jsp").forward(request, response);
	}
}