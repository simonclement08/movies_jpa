package dao;

import javax.persistence.EntityManager;

import entities.Genre;

/**
 * GenreDao
 *
 * Gère la persistance des genres
 *
 */
public class GenreDao extends AbstractDao<Genre> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public GenreDao(EntityManager em) {
		super(em, Genre.class);
	}
}
