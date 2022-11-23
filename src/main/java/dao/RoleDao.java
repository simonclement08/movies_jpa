package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Acteur;
import entities.Film;
import entities.Role;

/**
 * RoleDao
 *
 * Gère la persistance des rôles
 *
 */
public class RoleDao extends AbstractDao<Role> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public RoleDao(EntityManager em) {
		super(em, Role.class);
	}

	/**
	 * Extrait un rôle de la base en fonction de son characterName, son film et son
	 * acteur ou retourne null si le lieu n'existe pas.
	 * 
	 * @param characterName
	 * @param film
	 * @param acteur
	 * @return Role
	 */
	public Role find(String characterName, Film film, Acteur acteur) {

		TypedQuery<Role> query = em.createQuery("SELECT r FROM " + classe.getSimpleName() + " r "
				+ "JOIN r.film f "
				+ "JOIN r.acteur a " 
				+ "WHERE r.characterName = :characterName AND f.id = :film AND a.id = :acteur", classe);
		query.setParameter("characterName", characterName);
		query.setParameter("film", film.getId());
		query.setParameter("acteur", acteur.getId());

		List<Role> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}
}
