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

	//traite les différentes actions exercées sur la vue (suppréssion, ajout, ...)
	public void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String chemin = "/www/error.jsp";
		String[] splits = request.getServletPath().split("/");
		String operation = splits[splits.length - 1];

		if(operation.equals("accueil")) {
			request.setAttribute("utilisateur", utilisateurDAO.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur"))));
			chemin = "/www/accueil.jsp";
			System.err.println("consulterAccueil: go accueil.jsp");
		}

		if(operation.equals("consulterAlbum")) {
			request.setAttribute("utilisateur", utilisateurDAO.getUtilisateurById(Integer.parseInt(request.getParameter("idUtilisateur"))));
			request.setAttribute("album", albumDAO.getAlbumById(Integer.parseInt(request.getParameter("album"))));
			chemin = "/www/album.jsp";
			System.err.println("consulterAlbum: go album.jsp");
		}
		
		this.getServletContext().getRequestDispatcher(chemin).forward(request, response);
	}
}
