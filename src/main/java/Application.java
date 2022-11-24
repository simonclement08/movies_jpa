import java.util.Scanner;

import exceptions.MenuServiceException;
import service.AfficherCastingFilm;
import service.AfficherFilmographieActeur;
import service.MenuService;

/**
 * Application
 *
 * Application qui permet de réaliser des recherches dans les données avec un
 * menu
 * 
 */
public class Application {

	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("******** MENU FILM ********");

		boolean running = true;

		while (running) {
			System.out.println("	-----------------	");
			System.out.println("Choisissez une option :");
			System.out.println("1 - Afficher la filmographie d'un acteur donné");
			System.out.println("2 - Afficher le casting d’un film donné");
			System.out.println("3 - Afficher les films sortis entre 2 années données");
			System.out.println("4 - Afficher les films communs à 2 acteurs/actrices donnés.");
			System.out.println("5 - Afficher les acteurs communs à 2 films donnés");
			System.out.println(
					"6 - Afficher les films sortis entre 2 années données et qui ont un acteur/actrice donné au casting");
			System.out.println("7 - Sortir");

			String userChoice = scanner.nextLine();

			switch (userChoice) {
			case "1":
				MenuService service1 = new AfficherFilmographieActeur();
				try {
					service1.traiter(scanner);
				} catch (MenuServiceException e) {
					System.err.println(e.getMessage());
				}
				break;
			case "2":
				MenuService service2 = new AfficherCastingFilm();
				try {
					service2.traiter(scanner);
				} catch (MenuServiceException e) {
					System.err.println(e.getMessage());
				}
				break;
			case "3":

				break;
			case "4":
				break;
			case "5":

				break;
			case "6":

				break;
			case "7":
				running = false;
				break;
			}
		}

		scanner.close();
	}

}
