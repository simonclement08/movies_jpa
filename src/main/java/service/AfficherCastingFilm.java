package service;

import java.util.List;
import java.util.Scanner;

import dao.ActeurDao;
import dao.FilmDao;
import entities.Acteur;
import entities.Film;
import exceptions.MenuServiceException;

/**
 * AfficherCastingFilm
 *
 * Permet de rechercher en BDD tous les acteurs d'un films et de les afficher
 */
public class AfficherCastingFilm extends MenuService {

	@Override
	public void traiter(Scanner scanner) throws MenuServiceException {
		Film film = null;
		boolean isRunning = true;
		while (film == null && isRunning) {
			String nom = MenuService.afficherMessage(scanner, "un film");

			FilmDao filmDao = new FilmDao(em);
			film = filmDao.find(nom);

			if (film != null) {
				ActeurDao acteurDao = new ActeurDao(em);
				List<Acteur> acteurs = acteurDao.findByFilm(film);
				for (Acteur acteur : acteurs) {
					System.out.println("- " + acteur.getIdentite());
				}
			} else {
				isRunning = false;
				System.err.println("Aucun film trouvé, ce film n'existe pas dans la BDD");
			}
		}
	}

}
