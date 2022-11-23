package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Personne;

/**
 * PersonneDao
 *
 * Gère la persistance des personnes (acteurs ou réalisateurs)
 *
 */
public class PersonneDao extends AbstractDao<Personne> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public PersonneDao(EntityManager em) {
		super(em, Personne.class);
	}

	@Override
	public Personne find(String identite) {

		TypedQuery<Personne> query = em.createQuery("FROM " + classe.getSimpleName() + " WHERE identite=:identite",
				classe);
		query.setParameter("identite", identite);

		List<Personne> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}
}
