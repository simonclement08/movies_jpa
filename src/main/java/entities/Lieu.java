package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Lieu
 * 
 * Représente un lieu de tournage ou de naissance
 */
@Entity
@Table(name = "LIEU")
public class Lieu {

	/** Id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	/** Ville */
	@Column(name = "NOM", length = 255, nullable = true)
	private String ville;

	/** Etat / Département */
	@Column(name = "ETAT_DEPT", length = 255, nullable = true)
	private String etatDept;

	/** Pays */
	@ManyToOne
	@JoinColumn(name = "PAYS_ID", nullable = false)
	private Pays pays;

	/** Liste des acteurs né dans ce lieu */
	@OneToMany(mappedBy = "lieuNaissance")
	private List<Acteur> acteurs = new ArrayList<Acteur>();

	/** Liste des films par langue */
	@OneToMany(mappedBy = "lieuTournage")
	private List<Film> films = new ArrayList<Film>();

	/** Constructeur */
	public Lieu() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param ville
	 * @param etatDept
	 * @param pays
	 */
	public Lieu(String ville, String etatDept, Pays pays) {
		super();
		this.ville = ville;
		this.etatDept = etatDept;
		this.pays = pays;
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
	 * Getter pour l'attribut ville
	 *
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Setter pour l'attribut ville
	 *
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Getter pour l'attribut etatDept
	 *
	 * @return the etatDept
	 */
	public String getEtatDept() {
		return etatDept;
	}

	/**
	 * Setter pour l'attribut etatDept
	 *
	 * @param etatDept the etatDept to set
	 */
	public void setEtatDept(String etatDept) {
		this.etatDept = etatDept;
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
	 * Getter pour l'attribut acteurs
	 *
	 * @return the acteurs
	 */
	public List<Acteur> getActeurs() {
		return acteurs;
	}

	/**
	 * Getter pour l'attribut films
	 *
	 * @return the films
	 */
	public List<Film> getFilms() {
		return films;
	}

}
