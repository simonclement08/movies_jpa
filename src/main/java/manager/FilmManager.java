package manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Acteur;
import entities.Film;
import entities.Genre;
import entities.Realisateur;
import entities.Role;

/**
 * FilmManager
 *
 * Classe qui prend en charge la totalité du traitement d'un film
 *
 */
public class FilmManager {

	/** em Entity Manager */
	private EntityManager em;

	/** filmService */
	private FilmService filmService;

	/** genreService */
	private GenreService genreService;

	/** langueService */
	private LangueService langueService;

	/** lieuService */
	private LieuService lieuService;

	/** paysService */
	private PaysService paysService;

	/** personneService */
	private PersonneService personneService;

	/** roleService */
	private RoleService roleService;

	/** Constructeur */
	public FilmManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("movies");
		em = entityManagerFactory.createEntityManager();

		filmService = new FilmService(em);
		genreService = new GenreService(em);
		langueService = new LangueService(em);
		lieuService = new LieuService(em);
		paysService = new PaysService(em);
		personneService = new PersonneService(em);
		roleService = new RoleService(em);
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

		langueService.insertionEntite(film.getLangue());

		for (Genre genre : film.getGenres()) {
			genreService.insertionEntite(genre);
		}

		if (film.getPays() != null) {
			paysService.insertionEntite(film.getPays());
		}
		if (film.getLieuTournage() != null) {
			paysService.insertionEntite(film.getLieuTournage().getPays());
			lieuService.insertionEntite(film.getLieuTournage());
		}
		for (Realisateur realisateur : film.getRealisateurs()) {
			personneService.insertionEntite(realisateur);
		}

		for (Acteur acteur : film.getCastingPrincipal()) {
			paysService.insertionEntite(acteur.getLieuNaissance().getPays());
			lieuService.insertionEntite(acteur.getLieuNaissance());
			personneService.insertionEntite(acteur);
			System.out.println(acteur.getId());
			System.out.println(film.getId());
		}

//		for (Role role : film.getRoles()) {
//			paysService.insertionEntite(role.getActeur().getLieuNaissance().getPays());
//			lieuService.insertionEntite(role.getActeur().getLieuNaissance());
//			personneService.insertionEntite(role.getActeur());
//			role.setFilm(film);
//		}
//
//		
//		
//		for (Role role : film.getRoles()) {
//			roleService.insertionEntite(role);
//		}
		filmService.insertionEntite(film);
		transaction.commit();
	}

	/**
	 * Fermeture des ressources ouvertes par la classe
	 */
	public void close() {
		em.close();
	}

}
