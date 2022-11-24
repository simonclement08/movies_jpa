package manager;

import java.util.HashMap;
import java.util.List;

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

	/** realisateurService */
	private RealisateurService realisateurService;

	/** acteurService */
	private ActeurService acteurService;

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
		realisateurService = new RealisateurService(em);
		acteurService = new ActeurService(em);
		roleService = new RoleService(em);
	}

	/**
	 * Permet de supprimer les genres en doublons
	 * 
	 * @param list
	 */
	private static void removeDuplicateGenre(List<Genre> list) {
		HashMap<String, Genre> unique = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			if (unique.put(list.get(i).getNom(), list.get(i)) != null) {
				list.remove(i);
			}
		}
	}

	/**
	 * Permet de supprimer les acteurs en doublons
	 * 
	 * @param list
	 */
	private static void removeDuplicateActeur(List<Acteur> list) {
		HashMap<String, Acteur> unique = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			if (unique.put(list.get(i).getIdentite(), list.get(i)) != null) {
				list.remove(i);
			}
		}
	}

	/**
	 * Permet de supprimer les réalisateurs en doublons
	 * 
	 * @param list
	 */
	private static void removeDuplicateRealisateur(List<Realisateur> list) {
		HashMap<String, Realisateur> unique = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			if (unique.put(list.get(i).getIdentite(), list.get(i)) != null) {
				list.remove(i);
			}
		}
	}

	/**
	 * Permet de supprimer les rôles en doublons
	 * 
	 * @param list
	 */
	private static void removeDuplicateRole(List<Role> list) {
		HashMap<String, Role> unique = new HashMap<>();
		for (int i = 0; i < list.size(); i++) {
			if (unique.put(list.get(i).getCharacterName() + " " + list.get(i).getActeur().getIdentite(),
					list.get(i)) != null) {
				list.remove(i);
			}
		}
	}

	/**
	 * Traite un film: gère la totalité de la persistance du produit et de toutes
	 * ses données associées
	 * 
	 * @param film film à insérer en base de données.
	 */
	public void traiteFilm(Film film) {
		System.out.println(film.getNom());
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();

		if (film.getLangue() != null) {
			langueService.insertionEntite(film.getLangue());
		}

		FilmManager.removeDuplicateGenre(film.getGenres());
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

		FilmManager.removeDuplicateRealisateur(film.getRealisateurs());
		for (Realisateur realisateur : film.getRealisateurs()) {
			realisateurService.insertionEntite(realisateur);
		}

		FilmManager.removeDuplicateActeur(film.getCastingPrincipal());
		for (Acteur acteur : film.getCastingPrincipal()) {
			if (acteur.getLieuNaissance() != null) {
				paysService.insertionEntite(acteur.getLieuNaissance().getPays());
				lieuService.insertionEntite(acteur.getLieuNaissance());
			}
			acteurService.insertionEntite(acteur);
		}

		FilmManager.removeDuplicateRole(film.getRoles());
		for (Role role : film.getRoles()) {
			if (role.getActeur().getLieuNaissance() != null) {
				paysService.insertionEntite(role.getActeur().getLieuNaissance().getPays());
				lieuService.insertionEntite(role.getActeur().getLieuNaissance());
			}
			acteurService.insertionEntite(role.getActeur());
			role.setFilm(film);
			roleService.insertionEntite(role);
		}

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
