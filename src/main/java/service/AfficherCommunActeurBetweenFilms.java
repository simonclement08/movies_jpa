package service;

import java.util.List;
import java.util.Scanner;

import dao.ActeurDao;
import dao.FilmDao;
import entities.Acteur;
import entities.Film;

public class AfficherCommunActeurBetweenFilms extends MenuService {
	@Override
	public void traiter(Scanner scanner) {
		Film film1 = null;
		Film film2 = null;
		boolean isRunning = true;
		while (film1 == null && isRunning) {
			ActeurDao acteurDao = new ActeurDao(em);
			FilmDao filmDao = new FilmDao(em);

			String nom1 = MenuService.afficherMessage(scanner, "un film, '1' pour sortir");
			film1 = filmDao.find(nom1);
			if (film1 == null) {
				if (nom1.equals("1")) {
					isRunning = false;
				} else {
					System.err.println("Aucun film trouvé, ce film n'existe pas dans la BDD");
				}
			} else {
				while (film2 == null && isRunning) {
					String nom2 = MenuService.afficherMessage(scanner, "un autre film, '1' pour sortir");
					film2 = filmDao.find(nom2);
					if (film2 == null) {
						if (nom2.equals("1")) {
							isRunning = false;
						} else {
							System.err.println("Aucun film trouvé, ce film n'existe pas dans la BDD");
						}
					} else {
						List<Acteur> acteurs = acteurDao.findCommunActeur(film1, film2);
						if (acteurs.size() == 0) {
							System.out.println("Aucun acteur en commun entre ces deux films");
						}
						for (Acteur acteur : acteurs) {
							System.out.println("- " + acteur.getIdentite());
						}
					}
				}
			}
		}
	}
}
