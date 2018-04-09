package controleur;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele_DAO.AlbumDAO;
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

	public void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String chemin = "/www/error.jsp";
		String[] splits = request.getServletPath().split("/");
		String operation = splits[splits.length - 1];

		// Ajout d'un album
		if (operation.equals("albumAjout")) {
			System.err.println("Verification " + request.getParameter("idUtilisateur"));
			Album album = new Album(request.getParameter("titre"), request.getParameter("description"),
					Integer.parseInt(request.getParameter("idUtilisateur")), false, new Date(new java.util.Date().getTime()));

			if (albumDAO.insert(album) != 0) {
				Utilisateur utilisateur = utilisateurDAO.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur")));
				
				request.setAttribute("utilisateur", utilisateur);
				chemin = "/www/album_listing.jsp";
				System.err.println("AjoutAlbum: Album " + album.getNom() + " ajout�");
			} else {
				request.setAttribute("utilisateur", null);
				request.setAttribute("erreur", "Album non valide");
			}
		}
		
		if (operation.equals("albumCourant")) {

			if (albumDAO.setCourant(request.getParameter("album")) != 0) {				
				chemin = "/www/album_listing.jsp";
				System.err.println("AlbumCourant " + request.getParameter("albumCourant"));
			} else {
				request.setAttribute("erreur", "Album non supprim�");
			}
			System.err.println("AlbumCourant data value" + request.getParameter("data-value"));
		}
		
		if (operation.equals("albumSuppression")) {

			if (albumDAO.supprimer(request.getParameter("album")) != 0) {				
				chemin = "/www/album_listing.jsp";
				System.err.println("albumSuppression " + request.getParameter("albumSuppression") + " ajout�");
			} else {
				request.setAttribute("erreur", "Album non supprim�");
			}
			
			System.err.println("albumSuppression data value" + request.getParameter("data-value") + " ajout�");
		}

		this.getServletContext().getRequestDispatcher(chemin).forward(request, response);
	}
}
