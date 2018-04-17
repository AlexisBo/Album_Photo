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

	/**
	 * @param pseudo, email, mdp, telephone, dateNaissance
	 *            the pseudo, email, mdp, telephone, dateNaissance to set
	 */
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
	 * @return id
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
	 * @return pseudo
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
	 * @return email
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
	 * @return mdp
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

	/**
	 * @return telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telphone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance
	 *            the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return List Album
	 */
	public List<Album> getAlbums() {
		return new AlbumDAO().getAlbums(id);
	}

	/**
	 * @param List Albums
	 *            the List Albums to set
	 */
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

	/**
	 * @return List Commentaire
	 */
	public List<Commentaire> getCommentaires() {
		return new CommentaireDAO().getCommentairesByUtilisateur(id);
	}

	/**
	 * @param commentaire
	 *            the commentaire to set
	 */
	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}
}
