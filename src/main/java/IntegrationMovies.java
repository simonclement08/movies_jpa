import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;

import entities.Film;
import io.Reader;
import manager.FilmManager;

/**
 * Intégration
 * 
 * Application qui permet de parser le fichier JSON et de mettre en BDD les
 * données
 * 
 */
public class IntegrationMovies {

	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		List<Film> films = new ArrayList<Film>();

		try {
			films = Reader.getInstance().getFilmDtos(".\\src\\main\\resources\\json\\films.json");
		} catch (StreamReadException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (DatabindException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (IOException e) {
			e.getMessage();
			e.printStackTrace();
		} catch (ParseException e) {
			e.getMessage();
			e.printStackTrace();
		}

		FilmManager filmManager = new FilmManager();
		for (Film film : films) {
			filmManager.traiteFilm(film);
			System.out.println(film.getNom());
		}
	}

}
