package controleur;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modele_DAO.UtilisateurDAO;
import modele_entity.Utilisateur;

@WebServlet("/InscriptionUtilisateur")
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
			String pseudo = request.getParameter("pseudo");
			String email = request.getParameter("email");
			String mdp = request.getParameter("mdp");
			String telephone = request.getParameter("telephone");
			// Date dateNaissance = request.getParameter("dateNaissance");
			Utilisateur u = utilisateurDAO.sInscrire(pseudo, email, mdp, telephone/* , dateNaissance */);

			HttpSession session = request.getSession();

			if (u != null) {
				session.setAttribute("utilisateur", u);
			}
		}
	}
}
