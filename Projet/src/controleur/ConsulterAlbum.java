package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ConsulterAlbum extends HttpServlet {
	AlbumDAO AlbumDAO;

	public void init() {
		AlbumDAO = new AlbumDAO();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	public void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String album = request.getParameter("album");

		// Gestion de l'inscription
		Album a = albumDAO.visualiser(album);

		if (a != null) {
			request.setAttribute("album", a);
		} else {
			request.setAttribute("album", null);
		}

		this.getServletContext().getRequestDispatcher("/www/album_listing.jsp").forward(request, response);
	}
}