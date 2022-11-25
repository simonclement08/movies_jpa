package service;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import dao.ActeurDao;
import dao.FilmDao;
import entities.Acteur;
import entities.Film;
import exceptions.MenuServiceException;

/**
 * AfficherFilmographieActeurBetweenYears
 *
 * Permet de rechercher en BDD tous les films d'un acteur entre deux années et
 * de les afficher
 */
public class AfficherFilmographieActeurBetweenYears extends MenuService {

	@Override
	public void traiter(Scanner scanner) throws MenuServiceException {
		Acteur acteur = null;
		String yearMinUser = null;
		String yearMaxUser = null;
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
				while (!NumberUtils.isDigits(yearMinUser) && isRunning) {
					yearMinUser = MenuService.afficherMessage(scanner, "une première année, 'exit' pour sortir");
					if (!NumberUtils.isDigits(yearMinUser)) {
						if (yearMinUser.equals("exit")) {
							isRunning = false;
						} else {
							System.err.println("Veuillez saisir une année correcte");
						}
					} else {
						while (!NumberUtils.isDigits(yearMaxUser) && isRunning) {
							yearMaxUser = MenuService.afficherMessage(scanner, "une autre année, 'exit' pour sortir");
							if (NumberUtils.isDigits(yearMaxUser)) {
								Integer yearMin = Integer.parseInt(yearMinUser);
								Integer yearMax = Integer.parseInt(yearMaxUser);

								if (yearMin < 0 || yearMax < 0 || yearMax - yearMin < 0) {
									throw new MenuServiceException(
											"Veuillez saisir une année minimum et une année maximum cohérente");
								}

								FilmDao filmDao = new FilmDao(em);
								List<Film> films = filmDao.findBetweenYears(yearMin, yearMax);
								films.retainAll(filmDao.findByActeur(acteur));

								if (films.size() == 0) {
									System.out.println("Cet acteur n'a joué dans aucun film entre ces deux années");
								}

								for (Film film : films) {
									String annee = film.getAnneeSortie() == null ? ""
											: " (" + film.getAnneeSortie() + ")";
									System.out.println("- " + film.getNom() + annee);
								}

							} else {
								if (yearMaxUser.equals("exit")) {
									isRunning = false;
								} else {
									System.err.println("Veuillez saisir une année correcte");
								}
							}
						}
					}
				}
			}
		}
	}
}
