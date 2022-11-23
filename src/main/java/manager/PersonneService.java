package manager;

import javax.persistence.EntityManager;

import dao.PersonneDao;
import entities.Personne;

/**
 * PersonneService
 *
 * Classe qui propose des services de traitement des personnes
 *
 */
public class PersonneService {

	/** personneDao */
	private PersonneDao personneDao;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public PersonneService(EntityManager em) {
		personneDao = new PersonneDao(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite
	 */
	public void insertionEntite(Personne entite) {
		Personne entiteBase = personneDao.find(entite.getIdentite());
		if (entiteBase == null) {
			personneDao.insert(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}
}