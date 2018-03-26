package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modele_DAO.AlbumDAO;
import modele_entity.Album;

@WebServlet("/ConsulterAlbum")
public class GestionPhotos extends HttpServlet {

	private static final long serialVersionUID = 1L;

	AlbumDAO albumDAO;

	public void init() {
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

		// Visualisation d'un album
		if (operation.equals("consulter")) {
			String album = request.getParameter("album");
			
			Album a = albumDAO.visualiser(album);

			if (a != null) {
				request.setAttribute("album", a);
			} else {
				request.setAttribute("album", null);
			}
		}
		this.getServletContext().getRequestDispatcher("/www/album.jsp").forward(request, response);
	}
}