package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Acteur;
import entities.Film;

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
	
	/**
	 * Retourne tous les acteurs d'un film
	 * 
	 * @param film
	 * @return List<Acteur>
	 */
	public List<Acteur> findByFilm(Film film){
		TypedQuery<Acteur> query = em.createQuery("SELECT DISTINCT a "
				+ "FROM " + classe.getSimpleName() + " a "
				+ "JOIN a.castingPrincipal c "
				+ "JOIN a.roles r "
				+ "JOIN r.film f "
				+ "WHERE c.id = :id OR f.id = :id "
				+ "ORDER BY a.identite", classe);
		query.setParameter("id", film.getId());
		
		List<Acteur> resultsActeurs = query.getResultList();
		
		return resultsActeurs;
	}
}
