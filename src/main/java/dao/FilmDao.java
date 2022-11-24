package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Acteur;
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
	
	public List<Film> findByActeur(Acteur acteur) {

		TypedQuery<Film> query = em.createQuery("SELECT DISTINCT f FROM " + classe.getSimpleName() + " f "
				+ "JOIN f.castingPrincipal c "
				+ "JOIN f.roles r "
				+ "JOIN r.acteur a "
				+ "WHERE a.id = :id OR c.id = :id "
				+ "ORDER BY f.anneeSortie",
				classe);
		query.setParameter("id", acteur.getId());

		List<Film> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results;
	}
}
