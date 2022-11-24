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
	
	/**
	 * Retourne tous les films joués par un acteur
	 * 
	 * @param acteur
	 * @return List<Film>
	 */
	public List<Film> findByActeur(Acteur acteur) {
		TypedQuery<Film> query = em.createQuery("SELECT DISTINCT f "
				+ "FROM " + classe.getSimpleName() + " f "
				+ "JOIN f.castingPrincipal c "
				+ "JOIN f.roles r "
				+ "JOIN r.acteur a "
				+ "WHERE a.id = :id OR c.id = :id "
				+ "ORDER BY f.anneeSortie", classe);
		query.setParameter("id", acteur.getId());

		List<Film> resultsFilms = query.getResultList();

		return resultsFilms;
	}
	
	/**
	 * Retourne tous les films sortis entre yearMin et yearMax
	 * 
	 * @param yearMin
	 * @param yearMax
	 * @return List<Film>
	 */
	public List<Film> findBetweenYears(Integer yearMin, Integer yearMax) {
		TypedQuery<Film> query = em.createQuery("SELECT DISTINCT f "
				+ "FROM " + classe.getSimpleName() + " f "
				+ "WHERE f.anneeSortie >= :min AND f.anneeSortie <= :max "
				+ "ORDER BY f.anneeSortie", classe);
		query.setParameter("min", yearMin);
		query.setParameter("max", yearMax);

		List<Film> resultsFilms = query.getResultList();

		return resultsFilms;
	}
}
