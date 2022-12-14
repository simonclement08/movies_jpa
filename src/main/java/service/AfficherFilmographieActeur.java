package service;

import java.util.List;
import java.util.Scanner;

import dao.ActeurDao;
import dao.FilmDao;
import entities.Acteur;
import entities.Film;
import exceptions.MenuServiceException;

/**
 * AfficherFilmographieActeur
 *
 * Permet de rechercher en BDD tous les films d'un acteur et de les afficher
 */
public class AfficherFilmographieActeur extends MenuService {

	@Override
	public void traiter(Scanner scanner) throws MenuServiceException {
		Acteur acteur = null;
		boolean isRunning = true;
		while (acteur == null && isRunning) {
			String identite = MenuService.afficherMessage(scanner, "un acteur, '1' pour sortir");

			ActeurDao acteurDao = new ActeurDao(em);
			acteur = acteurDao.find(identite);

			if (acteur == null) {
				if (identite.equals("1")) {
					isRunning = false;
				} else {
					System.err.println("Aucun acteur trouvé, cet acteur n'existe pas dans la BDD");
				}
			} else {
				FilmDao filmDao = new FilmDao(em);
				List<Film> films = filmDao.findByActeur(acteur);

				if (films.size() == 0) {
					System.out.println("Cet acteur n'a joué dans aucun film");
				}

				for (Film film : films) {
					String annee = film.getAnneeSortie() == null ? "" : " (" + film.getAnneeSortie() + ")";
					System.out.println("- " + film.getNom() + annee);
				}
			}
		}
	}
}
