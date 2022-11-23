package manager;

import javax.persistence.EntityManager;

import dao.LangueDao;
import entities.Langue;

/**
 * LangueService
 *
 * Classe qui propose des services de traitement des lieux
 *
 */
public class LangueService {

	/** langueDao */
	private LangueDao langueDao;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public LangueService(EntityManager em) {
		langueDao = new LangueDao(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite
	 */
	public void insertionEntite(Langue entite) {
		Langue entiteBase = langueDao.find(entite.getNom());
		if (entiteBase == null) {
			langueDao.insert(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}
}
