package controleur;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele_DAO.UtilisateurDAO;
import modele_entity.Utilisateur;

public class InscriptionUtilisateur extends HttpServlet {

	private static final long serialVersionUID = 1L;

	UtilisateurDAO utilisateurDAO;

	public void init() {
		utilisateurDAO = new UtilisateurDAO();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String operation = request.getParameter("operation");

		// Gestion de la connexion
		if (operation.equals("inscription")) {
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			Utilisateur u = utilisateurDAO.seConnecter(login, pass);

			HttpSession session = request.getSession();

			if (u != null) {
				session.setAttribute("utilisateur", u);
			}

			this.getServletContext().getRequestDispatcher("/www/Album.xhtml").forward(request, response);
		}
	}
}
