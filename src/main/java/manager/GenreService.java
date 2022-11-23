package manager;

import javax.persistence.EntityManager;

import dao.GenreDao;
import entities.Genre;

/**
 * GenreService
 *
 * Classe qui propose des services de traitement des genres
 *
 */
public class GenreService {

	/** genreDao */
	private GenreDao genreDao;

	/**
	 * Constructeur
	 * 
	 * @param em
	 */
	public GenreService(EntityManager em) {
		genreDao = new GenreDao(em);
	}

	/**
	 * Insère l'entité en base de données
	 * 
	 * @param entite
	 */
	public void insertionEntite(Genre entite) {
		Genre entiteBase = genreDao.find(entite.getNom());
		if (entiteBase == null) {
			genreDao.insert(entite);
		} else {
			entite.setId(entiteBase.getId());
		}
	}

}
