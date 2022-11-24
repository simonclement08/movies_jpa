package manager;

import javax.persistence.EntityManager;

import dao.ActeurDao;
import entities.Acteur;

/**
 * ActeurService
 *
 * Classe qui propose des services de traitement des acteurs
 *
 */
public class ActeurService {

	/** personneDao */
	private ActeurDao acteurDao;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public ActeurService(EntityManager em) {
		acteurDao = new ActeurDao(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite
	 */
	public void insertionEntite(Acteur entite) {
		Acteur entiteBase = acteurDao.find(entite.getIdentite());
		if (entiteBase == null) {
			acteurDao.insert(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}
}