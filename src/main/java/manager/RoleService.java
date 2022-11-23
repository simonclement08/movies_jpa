package manager;

import javax.persistence.EntityManager;

import dao.RoleDao;
import entities.Role;

/**
 * RoleService
 *
 * Classe qui propose des services de traitement des rôles
 *
 */
public class RoleService {

	/** roleDao */
	private RoleDao roleDao;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public RoleService(EntityManager em) {
		roleDao = new RoleDao(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite
	 */
	public void insertionEntite(Role entite) {
		Role entiteBase = roleDao.find(entite.getCharacterName(), entite.getFilm(), entite.getActeur());
		if (entiteBase == null) {
			roleDao.insert(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}

}