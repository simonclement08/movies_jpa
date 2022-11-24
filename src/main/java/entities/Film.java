package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Film
 * 
 * Représente un film
 */
@Entity
@Table(name = "FILM")
@Cacheable
public class Film {

	/** Id */
	@Id
	@Column(name = "ID")
	private String id;

	/** Nom */
	@Column(name = "NOM", length = 255, nullable = false)
	private String nom;

	/** Url */
	@Column(name = "URL", length = 255, nullable = false)
	private String url;

	/** Plot : Courte description */
	@Column(name = "PLOT", length = 255, nullable = true)
	private String plot;

	/** Année de sortie */
	@Column(name = "ANNEE_SORTIE", nullable = true)
	private Integer anneeSortie;

	/** Langue */
	@ManyToOne
	@JoinColumn(name = "LANGUE_ID", nullable = true)
	private Langue langue;

	@ManyToMany
	@JoinTable(name = "FILM_GENRE", 
		uniqueConstraints = { @UniqueConstraint(columnNames = { "FILM_ID", "GENRE_ID" }) },
		joinColumns = @JoinColumn(name = "FILM_ID", referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "GENRE_ID", referencedColumnName = "ID"))
	private List<Genre> genres = new ArrayList<Genre>();

	/** Pays d'origine */
	@ManyToOne
	@JoinColumn(name = "PAYS_ID", nullable = true)
	private Pays pays;

	/** Lieu de tournage principale */
	@ManyToOne
	@JoinColumn(name = "LIEU_TOURNAGE_ID", nullable = true)
	private Lieu lieuTournage;

	@ManyToMany
	@JoinTable(name = "REALISATEUR_FILM", 
		uniqueConstraints = { @UniqueConstraint(columnNames = { "FILM_ID", "REALISATEUR_ID" }) },
		joinColumns = @JoinColumn(name = "FILM_ID", referencedColumnName = "ID"),
		inverseJoinColumns = @JoinColumn(name = "REALISATEUR_ID", referencedColumnName = "ID"))
	private List<Realisateur> realisateurs = new ArrayList<Realisateur>();

	@ManyToMany
	@JoinTable(name = "MAIN_ACTEUR",
		uniqueConstraints = { @UniqueConstraint(columnNames = { "FILM_ID", "ACTEUR_ID" }) }, 
		joinColumns = @JoinColumn(name = "FILM_ID", referencedColumnName = "ID"), 
		inverseJoinColumns = @JoinColumn(name = "ACTEUR_ID", referencedColumnName = "ID"))
	private List<Acteur> castingPrincipal = new ArrayList<Acteur>();

	/** Liste des rôles dans le film */
	@OneToMany(mappedBy = "film")
	private List<Role> roles = new ArrayList<Role>();

	/** Constructeur */
	public Film() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param id
	 * @param nom
	 * @param url
	 * @param langue
	 * @param pays
	 */
	public Film(String id, String nom, String url, Langue langue, Pays pays) {
		super();
		this.id = id;
		this.nom = nom;
		this.url = url;
		this.langue = langue;
		this.pays = pays;
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
	 * Getter pour l'attribut plot
	 *
	 * @return the plot
	 */
	public String getPlot() {
		return plot;
	}

	/**
	 * Setter pour l'attribut plot
	 *
	 * @param plot the plot to set
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}

	/**
	 * Getter pour l'attribut anneeSortie
	 *
	 * @return the anneeSortie
	 */
	public Integer getAnneeSortie() {
		return anneeSortie;
	}

	/**
	 * Setter pour l'attribut anneeSortie
	 *
	 * @param anneeSortie the anneeSortie to set
	 */
	public void setAnneeSortie(Integer anneeSortie) {
		this.anneeSortie = anneeSortie;
	}

	/**
	 * Getter pour l'attribut langue
	 *
	 * @return the langue
	 */
	public Langue getLangue() {
		return langue;
	}

	/**
	 * Setter pour l'attribut langue
	 *
	 * @param langue the langue to set
	 */
	public void setLangue(Langue langue) {
		this.langue = langue;
	}

	/**
	 * Getter pour l'attribut pays
	 *
	 * @return the pays
	 */
	public Pays getPays() {
		return pays;
	}

	/**
	 * Setter pour l'attribut pays
	 *
	 * @param pays the pays to set
	 */
	public void setPays(Pays pays) {
		this.pays = pays;
	}

	/**
	 * Getter pour l'attribut lieuTournage
	 *
	 * @return the lieuTournage
	 */
	public Lieu getLieuTournage() {
		return lieuTournage;
	}

	/**
	 * Setter pour l'attribut lieuTournage
	 *
	 * @param lieuTournage the lieuTournage to set
	 */
	public void setLieuTournage(Lieu lieuTournage) {
		this.lieuTournage = lieuTournage;
	}

	/**
	 * Getter pour l'attribut genres
	 *
	 * @return the genres
	 */
	public List<Genre> getGenres() {
		return genres;
	}

	/**
	 * Getter pour l'attribut realisateurs
	 *
	 * @return the realisateurs
	 */
	public List<Realisateur> getRealisateurs() {
		return realisateurs;
	}

	/**
	 * Getter pour l'attribut castingPrincipal
	 *
	 * @return the castingPrincipal
	 */
	public List<Acteur> getCastingPrincipal() {
		return castingPrincipal;
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
