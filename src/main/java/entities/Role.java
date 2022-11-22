package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Role
 * 
 * Représente un rôle
 */
@Entity
@Table(name = "ROLE")
public class Role {

	/** Id */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	/** Identité */
	@Column(name = "CHARACTER_NAME", length = 50, nullable = true)
	protected String characterName;

	/** Film */
	@ManyToOne
	@JoinColumn(name = "FILM_ID", nullable = false)
	private Film film;

	/** Acteur */
	@ManyToOne
	@JoinColumn(name = "ACTEUR_ID", nullable = false)
	private Acteur acteur;

	/** Constructeur */
	public Role() {
		super();
	}

	/**
	 * Constructeur sans nom de rôle
	 *
	 * @param id
	 * @param film
	 * @param acteur
	 */
	public Role(Film film, Acteur acteur) {
		super();
		this.film = film;
		this.acteur = acteur;
	}

	/**
	 * Constructeur
	 *
	 * @param id
	 * @param characterName
	 * @param film
	 * @param acteur
	 */
	public Role(String characterName, Film film, Acteur acteur) {
		super();
		this.characterName = characterName;
		this.film = film;
		this.acteur = acteur;
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
	 * Getter pour l'attribut characterName
	 *
	 * @return the characterName
	 */
	public String getCharacterName() {
		return characterName;
	}

	/**
	 * Setter pour l'attribut characterName
	 *
	 * @param characterName the characterName to set
	 */
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	/**
	 * Getter pour l'attribut film
	 *
	 * @return the film
	 */
	public Film getFilm() {
		return film;
	}

	/**
	 * Setter pour l'attribut film
	 *
	 * @param film the film to set
	 */
	public void setFilm(Film film) {
		this.film = film;
	}

	/**
	 * Getter pour l'attribut acteur
	 *
	 * @return the acteur
	 */
	public Acteur getActeur() {
		return acteur;
	}

	/**
	 * Setter pour l'attribut acteur
	 *
	 * @param acteur the acteur to set
	 */
	public void setActeur(Acteur acteur) {
		this.acteur = acteur;
	}

}
