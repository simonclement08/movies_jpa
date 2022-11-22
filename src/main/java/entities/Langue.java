package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Langue
 * 
 * Représente une langue
 */
@Entity
@Table(name = "LANGUE")
public class Langue {

	/** Id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	/** Nom */
	@Column(name = "NOM", length = 50, nullable = false)
	private String nom;

	/** Liste des films par langue */
	@OneToMany(mappedBy = "langue")
	private List<Film> films = new ArrayList<Film>();

	/** Constructeur */
	public Langue() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param nom Nom
	 */
	public Langue(String nom) {
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
	 * Getter pour l'attribut films
	 *
	 * @return the films
	 */
	public List<Film> getFilms() {
		return films;
	}

}
