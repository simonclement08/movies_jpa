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
		while (acteur == null) {
			String identite = MenuService.afficherMessage(scanner, "un acteur");

			ActeurDao acteurDao = new ActeurDao(em);
			acteur = acteurDao.find(identite);
			
			if (acteur != null) {
				FilmDao filmDao = new FilmDao(em);
				List<Film> films = filmDao.findByActeur(acteur);
				for (Film film : films) {
					String annee = film.getAnneeSortie() == null ? "" : " (" + film.getAnneeSortie() + ")";
					System.out.println("- " + film.getNom() + annee);
				}
			} else {
				throw new MenuServiceException("Aucun acteur trouvé, cet acteur n'existe pas dans la BDD");
			}
		}
	}
}
