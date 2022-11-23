package manager;

import javax.persistence.EntityManager;

import dao.FilmDao;
import entities.Film;

/**
 * FilmService
 *
 * Classe qui propose des services de traitement des films
 *
 */
public class FilmService {

	/** genreDao */
	private FilmDao filmDao;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public FilmService(EntityManager em) {
		filmDao = new FilmDao(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite
	 */
	public void insertionEntite(Film entite) {
		Film entiteBase = filmDao.find(entite.getNom());
		if (entiteBase == null) {
			filmDao.insert(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}

}
