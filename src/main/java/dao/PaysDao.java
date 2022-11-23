package dao;

import javax.persistence.EntityManager;

import entities.Pays;

/**
 * PaysDao
 *
 * Gère la persistance des pays
 *
 */
public class PaysDao extends AbstractDao<Pays> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public PaysDao(EntityManager em) {
		super(em, Pays.class);
	}
}
