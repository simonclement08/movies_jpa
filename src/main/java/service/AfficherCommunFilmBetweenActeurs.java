package service;

import java.util.List;
import java.util.Scanner;

import dao.ActeurDao;
import dao.FilmDao;
import entities.Acteur;
import entities.Film;

/**
 * AfficherCommunFilmBetweenActeurs
 *
 * Permet de rechercher en BDD tous les films commun entre deux acteurs
 */
public class AfficherCommunFilmBetweenActeurs extends MenuService {

	@Override
	public void traiter(Scanner scanner) {
		Acteur acteur1 = null;
		Acteur acteur2 = null;
		boolean isRunning = true;
		while (acteur1 == null && isRunning) {
			ActeurDao acteurDao = new ActeurDao(em);
			FilmDao filmDao = new FilmDao(em);

			String identite1 = MenuService.afficherMessage(scanner, "un acteur, '1' pour sortir");
			acteur1 = acteurDao.find(identite1);
			if (acteur1 == null) {
				if (identite1.equals("1")) {
					isRunning = false;
				} else {
					System.err.println("Aucun acteur trouvé, cet acteur n'existe pas dans la BDD");
				}
			} else {
				while (acteur2 == null && isRunning) {
					String identite2 = MenuService.afficherMessage(scanner, "un autre acteur, '1' pour sortir");
					acteur2 = acteurDao.find(identite2);
					if (acteur2 == null) {
						if (identite2.equals("1")) {
							isRunning = false;
						} else {
							System.err.println("Aucun acteur trouvé, cet acteur n'existe pas dans la BDD");
						}
					} else {
						List<Film> films = filmDao.findCommunFilm(acteur1, acteur2);
						if (films.size() == 0) {
							System.out.println("Aucun film en commun entre ces deux acteurs");
						}
						for (Film film : films) {
							String annee = film.getAnneeSortie() == null ? "" : " (" + film.getAnneeSortie() + ")";
							System.out.println("- " + film.getNom() + annee);
						}
					}
				}
			}
		}
	}
}
