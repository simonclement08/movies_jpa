package manager;

import javax.persistence.EntityManager;

import dao.RealisateurDao;
import entities.Realisateur;

/**
 * RealisateurService
 *
 * Classe qui propose des services de traitement des réalisateurs
 *
 */
public class RealisateurService {

	/** personneDao */
	private RealisateurDao realisateurDao;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public RealisateurService(EntityManager em) {
		realisateurDao = new RealisateurDao(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite
	 */
	public void insertionEntite(Realisateur entite) {
		Realisateur entiteBase = realisateurDao.find(entite.getIdentite());
		if (entiteBase == null) {
			realisateurDao.insert(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}
}