package modele_entity;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import modele_DAO.AlbumDAO;
import modele_DAO.CommentaireDAO;
import modele_DAO.GenericDAO;

public class Utilisateur implements Observer {
	private int id;
	private String pseudo;
	private String email;
	private String mdp;
	private String telephone;
	private Date dateNaissance;
	private List<Album> albums;
	private List<Commentaire> commentaires;

	public Utilisateur(String pseudo, String email, String mdp, String telephone, Date dateNaissance) {
		this.setUtilisateur(pseudo, email, mdp, telephone, dateNaissance);
	}

	public Utilisateur(int id, String pseudo, String email, String mdp, String telephone, Date dateNaissance) {
		this.id = id;
		this.setUtilisateur(pseudo, email, mdp, telephone, dateNaissance);
	}

	private void setUtilisateur(String pseudo, String email, String mdp, String telephone, Date dateNaissance) {
		this.pseudo = pseudo;
		this.email = email;
		this.mdp = mdp;
		this.telephone = telephone;
		this.dateNaissance = dateNaissance;
		this.commentaires = new ArrayList<>();

		this.albums = new ArrayList<>();
		this.albums.add(new Album("Courant", "Ce dossier est votre premier album de medias", id, true,
				new Date(new java.util.Date().getTime())));

		String chemin = GenericDAO.MEDIAS_CHEMIN_ABSOLUE + this.pseudo + "\\" + this.albums.get(0).getNom();

		File file = new File(chemin);
		if(!file.exists()) {
			file.mkdirs();
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo
	 *            the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp
	 *            the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public List<Album> getAlbums() {
		return new AlbumDAO().getAlbums(id);
	}

	public void setAlbums(List<Album> albums) {
		this.albums = albums;
	}

	public void insertAlbums() {
		for (Album album : albums) {
			System.err.println(album.getNom());
			if (new AlbumDAO().insert(album) != 0) {
				System.err.println("Ajout: Album " + album.getNom());
			}
		}
	}

	public List<Commentaire> getCommentaires() {
		return new CommentaireDAO().getCommentairesByUtilisateur(id);
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
}
