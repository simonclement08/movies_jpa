package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Realisateur;

/**
 * RealisateurDao
 *
 * Gère la persistance des réalisateurs
 *
 */
public class RealisateurDao extends AbstractDao<Realisateur> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public RealisateurDao(EntityManager em) {
		super(em, Realisateur.class);
	}

	@Override
	public Realisateur find(String identite) {

		TypedQuery<Realisateur> query = em.createQuery("FROM " + classe.getSimpleName() + " WHERE identite=:identite",
				classe);
		query.setParameter("identite", identite);

		List<Realisateur> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}
}
