package manager;

import javax.persistence.EntityManager;

import dao.LieuDao;
import entities.Lieu;

/**
 * LieuService
 *
 * Classe qui propose des services de traitement des lieux
 *
 */
public class LieuService {

	/** lieuDao */
	private LieuDao lieuDao;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public LieuService(EntityManager em) {
		lieuDao = new LieuDao(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite
	 */
	public void insertionEntite(Lieu entite) {
		Lieu entiteBase = lieuDao.find(entite.getVille(), entite.getEtatDept(), entite.getPays());
		if (entiteBase == null) {
			lieuDao.insert(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}

}