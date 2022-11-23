package manager;

import javax.persistence.EntityManager;

import dao.PaysDao;
import entities.Pays;

/**
 * PaysService
 *
 * Classe qui propose des services de traitement des pays
 *
 */
public class PaysService {

	/** paysDao */
	private PaysDao paysDao;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public PaysService(EntityManager em) {
		paysDao = new PaysDao(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite
	 */
	public void insertionEntite(Pays entite) {
		Pays entiteBase = paysDao.find(entite.getNom());
		if (entiteBase == null) {
			paysDao.insert(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}

}