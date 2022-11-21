package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ACTEUR")
public class Acteur extends Personne {

	/** Taille */
	@Column(name = "HEIGHT", nullable = true)
	private double height;

	/** Date de naissance */
	@Temporal(TemporalType.DATE)
	@Column(name = "DATE_NAISSANCE", nullable = true)
	private Date dateNaissance;

	/** Lieu de naissance */
	@ManyToOne
	@JoinColumn(name = "LIEUX_NAISSANCE_ID", nullable = true)
	private Pays lieuNaissance;
	
	/** Liste des rôles de l'acteur */
	@OneToMany(mappedBy = "acteur")
	private List<Role> roles = new ArrayList<Role>();

	/** Constructeur */
	public Acteur() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param id
	 * @param identite
	 * @param url
	 */
	public Acteur(String id, String identite, String url) {
		super(id, identite, url);
	}

	/**
	 * Getter pour l'attribut height
	 *
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * Setter pour l'attribut height
	 *
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Getter pour l'attribut dateNaissance
	 *
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Setter pour l'attribut dateNaissance
	 *
	 * @param dateNaissance the dateNaissance to set
	 */
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Getter pour l'attribut lieuNaissance
	 *
	 * @return the lieuNaissance
	 */
	public Pays getLieuNaissance() {
		return lieuNaissance;
	}

	/**
	 * Setter pour l'attribut lieuNaissance
	 *
	 * @param lieuNaissance the lieuNaissance to set
	 */
	public void setLieuNaissance(Pays lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	/**
	 * Getter pour l'attribut roles
	 *
	 * @return the roles
	 */
	public List<Role> getRoles() {
		return roles;
	}

}
