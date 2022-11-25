package service;

import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.math.NumberUtils;

import dao.FilmDao;
import entities.Film;
import exceptions.MenuServiceException;

/**
 * AfficherFilmBetweenYears
 *
 * Permet de rechercher en BDD tous les films entre deux années et de les
 * afficher
 */
public class AfficherFilmBetweenYears extends MenuService {

	@Override
	public void traiter(Scanner scanner) throws MenuServiceException {
		String yearMinUser = null;
		String yearMaxUser = null;
		boolean isRunning = true;
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
					if (!NumberUtils.isDigits(yearMaxUser)) {
						if (yearMaxUser.equals("exit")) {
							isRunning = false;
						} else {
							System.err.println("Veuillez saisir une année correcte");
						}
					} else {
						Integer yearMin = Integer.parseInt(yearMinUser);
						Integer yearMax = Integer.parseInt(yearMaxUser);

						if (yearMin < 0 || yearMax < 0 || yearMax - yearMin < 0) {
							throw new MenuServiceException(
									"Veuillez saisir une année minimum et une année maximum cohérente");
						}

						FilmDao filmDao = new FilmDao(em);
						List<Film> films = filmDao.findBetweenYears(yearMin, yearMax);
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
