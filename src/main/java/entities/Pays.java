package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Pays
 * 
 * Représente un pays
 */
@Entity
@Table(name = "PAYS")
@Cacheable
public class Pays {

	/** Id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	/** Nom */
	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;

	/** Url */
	@Column(name = "URL", length = 255, nullable = true)
	private String url;

	/** Liste des lieux du pays */
	@OneToMany(mappedBy = "pays")
	private List<Lieu> lieux = new ArrayList<Lieu>();

	/** Liste des films par pays */
	@OneToMany(mappedBy = "pays")
	private List<Film> films = new ArrayList<Film>();

	/** Constructeur */
	public Pays() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param nom Nom
	 */
	public Pays(String nom) {
		super();
		this.nom = nom;
	}

	/**
	 * Getter pour l'attribut id
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter pour l'attribut id
	 *
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Getter pour l'attribut nom
	 *
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour l'attribut nom
	 *
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
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

	/**
	 * Getter pour l'attribut lieux
	 *
	 * @return the lieux
	 */
	public List<Lieu> getLieux() {
		return lieux;
	}

}
