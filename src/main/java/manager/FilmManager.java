package manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Film;

/**
 * FilmManager
 *
 * Classe qui prend en charge la totalité du traitement d'un film
 *
 */
public class FilmManager {

	/** em Entity Manager */
	private EntityManager em;

	/** Constructeur */
	public FilmManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("movies");
		em = entityManagerFactory.createEntityManager();
	}

	/**
	 * Traite un film: gère la totalité de la persistance du produit et de toutes
	 * ses données associées
	 * 
	 * @param film film à insérer en base de données.
	 */
	public void traiteFilm(Film film) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		transaction.commit();
	}

	/**
	 * Fermeture des ressources ouvertes par la classe
	 */
	public void close() {
		em.close();
	}

}
