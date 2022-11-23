package entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * Personne
 * 
 * Représente un réalisateur ou un acteur
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "PERSONNE")
public abstract class Personne {

	/** Id */
	@Id
	@Column(name = "ID")
	protected String id;

	/** Identité */
	@Column(name = "IDENTITE", length = 255, nullable = false)
	protected String identite;

	/** Url */
	@Column(name = "URL", length = 255, nullable = false)
	protected String url;

	/** Constructeur */
	public Personne() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param id
	 * @param identite
	 * @param url
	 */
	public Personne(String id, String identite, String url) {
		super();
		this.id = id;
		this.identite = identite;
		this.url = url;
	}

	/**
	 * Getter pour l'attribut id
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter pour l'attribut id
	 *
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Getter pour l'attribut identite
	 *
	 * @return the identite
	 */
	public String getIdentite() {
		return identite;
	}

	/**
	 * Setter pour l'attribut identite
	 *
	 * @param identite the identite to set
	 */
	public void setIdentite(String identite) {
		this.identite = identite;
	}

	/**
	 * Getter pour l'attribut url
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Setter pour l'attribut url
	 *
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
