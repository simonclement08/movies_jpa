package dao;

import javax.persistence.EntityManager;

import entities.Langue;

/**
 * LangueDao
 *
 * Gère la persistance des langues
 *
 */
public class LangueDao extends AbstractDao<Langue> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public LangueDao(EntityManager em) {
		super(em, Langue.class);
	}
}
