package dao;

import javax.persistence.EntityManager;

import entities.Film;

/**
 * FilmDao
 *
 * Gère la persistance des films
 *
 */
public class FilmDao extends AbstractDao<Film> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public FilmDao(EntityManager em) {
		super(em, Film.class);
	}
}
