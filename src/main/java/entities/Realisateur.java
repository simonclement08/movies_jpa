package entities;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Realisateur
 * 
 * Représente un réalisateur
 */
@Entity
@Table(name = "REALISATEUR")
@Cacheable
public class Realisateur extends Personne {

	/** Constructeur */
	public Realisateur() {
		super();
	}

	/**
	 * Constructeur
	 *
	 * @param id
	 * @param identite
	 * @param url
	 */
	public Realisateur(String id, String identite, String url) {
		super(id, identite, url);
	}

	@Override
	public String toString() {
		return "Realisateur [getId()=" + getId() + ", getIdentite()=" + getIdentite() + ", getUrl()=" + getUrl() + "]";
	}

}
