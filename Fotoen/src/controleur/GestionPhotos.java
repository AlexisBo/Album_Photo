package controleur;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele_DAO.AlbumDAO;
import modele_DAO.GenericDAO;
import modele_DAO.MediaDAO;
import modele_DAO.UtilisateurDAO;
import modele_entity.Media;
import modele_entity.Utilisateur;

@WebServlet("/ConsulterAlbum")
public class GestionPhotos extends HttpServlet {

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
			
			Part file = request.getPart("media");
			final String fileName = getFileName(file);

			OutputStream out = null;
			InputStream filecontent = null;
			final PrintWriter writer = response.getWriter();
			
			String path = GenericDAO.MEDIAS_CHEMIN_ABSOLUE + utilisateur.getPseudo() + "\\" + albumDAO.getAlbumCurrent(utilisateur.getId()) + "\\";

			try {
				out = new FileOutputStream(new File(path + "\\" + fileName));
				filecontent = file.getInputStream();

				int read = 0;
				final byte[] bytes = new byte[1024];

				while ((read = filecontent.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}
			} catch (FileNotFoundException fne) {

			} finally {
				if (out != null) {
					out.close();
				}
				if (filecontent != null) {
					filecontent.close();
				}
				if (writer != null) {
					writer.close();
				}
			}

			Media media = new Media(request.getParameter("lien"), request.getParameter("description"),
					Integer.parseInt(request.getParameter("idUtilisateur"),
							Integer.parseInt(request.getParameter("idAlbum"))),
					false, new Date(new java.util.Date().getTime()));

			if (mediaDAO.insert(media) != 0) {
				Utilisateur utilisateur = utilisateurDAO
						.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur")));

				request.setAttribute("utilisateur", utilisateur);
				chemin = "/www/album_listing.jsp";
				System.err.println("AjoutAlbum: Album " + media.getLien() + " ajouté");
			} else {
				request.setAttribute("utilisateur", null);
				request.setAttribute("erreur", "Album non valide");
			}
		}

		// Visualisation d'une photo
		if (operation.equals("consulterMedia")) {
			request.setAttribute("utilisateur",
					utilisateurDAO.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur"))));
			Media media = mediaDAO.getMediaById(Integer.parseInt(request.getParameter("media")));

			if (media != null) {
				request.setAttribute("media", media);
				chemin = "/www/media.jsp";
				System.err.println("Visualisation: Photo " + media.getLien());
			} else {
				request.setAttribute("erreur", "Photo non consultable");
			}
		}
		//
		// //Suppression d'une photo
		// if (operation.equals("mediaSuppression")) {
		//
		// if (mediaDAO.supprimer(request.getParameter("media")) != 0) {
		// chemin = "/www/album_listing.jsp";
		// System.err.println("mediaSuppression " +
		// request.getParameter("mediaSuppression") + " ajoutÃ©");
		// } else {
		// request.setAttribute("erreur", "MÃ©dia non supprimÃ©");
		// }
		//
		// System.err.println("mediaSuppression data value" +
		// request.getParameter("data-value") + " ajoutÃ©");
		// }

		this.getServletContext().getRequestDispatcher(chemin).forward(request, response);
	}
}