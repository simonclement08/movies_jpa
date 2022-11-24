package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Acteur;

/**
 * RealisateurDao
 *
 * Gère la persistance des acteurs
 *
 */
public class ActeurDao extends AbstractDao<Acteur> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public ActeurDao(EntityManager em) {
		super(em, Acteur.class);
	}

	@Override
	public Acteur find(String identite) {

		TypedQuery<Acteur> query = em.createQuery("FROM " + classe.getSimpleName() + " WHERE identite=:identite",
				classe);
		query.setParameter("identite", identite);

		List<Acteur> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}
}
