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
import modele_DAO.UtilisateurDAO;
import modele_entity.Album;
import modele_entity.Utilisateur;

@WebServlet("/GestionAlbums")
public class GestionAlbums extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UtilisateurDAO utilisateurDAO;
	AlbumDAO albumDAO;

	public void init() {
		utilisateurDAO = new UtilisateurDAO();
		albumDAO = new AlbumDAO();
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

		// Ajout d'un album
		if (operation.equals("albumAjout")) {
			Utilisateur utilisateur = utilisateurDAO
					.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur")));
			Album album = new Album(request.getParameter("titre"), request.getParameter("description"),
					Integer.parseInt(request.getParameter("idUtilisateur")), false,
					new Date(new java.util.Date().getTime()));

			if (albumDAO.insert(album) != 0) {
				File file = new File(
						GenericDAO.MEDIAS_CHEMIN_ABSOLUE + utilisateur.getPseudo() + "\\" + album.getNom());
				file.mkdir();
				request.setAttribute("utilisateur", utilisateur);
				chemin = "/www/album_listing.jsp";
				System.err.println("AjoutAlbum: Album " + album.getNom() + " ajouté");
			} else {
				request.setAttribute("utilisateur", utilisateur);
				request.setAttribute("erreur", "Album non valide");
			}
		}

		if (operation.equals("albumCourant")) {
			Utilisateur utilisateur = utilisateurDAO
					.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur")));

			if (albumDAO.setCourant(Integer.parseInt(request.getParameter("idUtilisateur")),
					Integer.parseInt(request.getParameter("album"))) != 0) {
				chemin = "/www/album_listing.jsp";
				request.setAttribute("utilisateur", utilisateur);
				System.err.println("AlbumCourant: Album " + request.getParameter("album") + " courant");
			} else {
				request.setAttribute("utilisateur", utilisateur);
				request.setAttribute("erreur", "Album courant non modifié");
			}
		}

		if (operation.equals("albumSuppression")) {
			Utilisateur utilisateur = utilisateurDAO
					.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur")));

			if (albumDAO.supprimer(Integer.parseInt(request.getParameter("album"))) != 0) {
				File file = new File(GenericDAO.MEDIAS_CHEMIN_ABSOLUE + utilisateur.getPseudo() + "\\"
						+ request.getParameter("album"));
				file.delete();
				chemin = "/www/album_listing.jsp";
				request.setAttribute("utilisateur", utilisateur);
				System.err.println("albumSuppression: Album " + request.getParameter("album") + " supprimé");
			} else {
				request.setAttribute("utilisateur", utilisateur);
				request.setAttribute("erreur", "Album non supprimé");
			}
		}

		this.getServletContext().getRequestDispatcher(chemin).forward(request, response);
	}
}
