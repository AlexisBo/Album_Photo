package controleur;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele_DAO.AlbumDAO;
import modele_DAO.UtilisateurDAO;
import modele_entity.Utilisateur;

public class C_GestionAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UtilisateurDAO utilisateurDAO;
	AlbumDAO albumDAO;

	public void init() {
		utilisateurDAO = new UtilisateurDAO();
		albumDAO = new AlbumDAO();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String operation = request.getParameter("operation");

		// Gestion de la connexion
		if (operation.equals("seConnecter")) {
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			Utilisateur u = utilisateurDAO.seConnecter(login, pass);
			
			HttpSession session = request.getSession();

	        if ( u != null ) {
	            session.setAttribute( "utilistauer", u );
	        }
			
			RequestDispatcher dispatch = request
					.getRequestDispatcher("/www/Album.html");
			dispatch.forward(request, response);
		}
	}
}