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
			String nom = MenuService.afficherMessage(scanner, "un film, '1' pour sortir");

			FilmDao filmDao = new FilmDao(em);
			film = filmDao.find(nom);

			if (film == null) {
				if (nom.equals("1")) {
					isRunning = false;
				} else {
					System.err.println("Aucun film trouvé, ce film n'existe pas dans la BDD");
				}
			} else {
				ActeurDao acteurDao = new ActeurDao(em);
				List<Acteur> acteurs = acteurDao.findByFilm(film);
				if (acteurs.size() == 0) {
					System.out.println("Aucun acteur n'est enregistré pour ce film");
				}
				for (Acteur acteur : acteurs) {
					System.out.println("- " + acteur.getIdentite());
				}
			}
		}
	}

}
