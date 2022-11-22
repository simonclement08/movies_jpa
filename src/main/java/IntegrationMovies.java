import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.FilmDto;
import entities.Film;
import mappers.FilmMapper;

/**
 * Intégration
 * 
 * Application qui permet de parser le fichier JSON et de mettre en BDD les données
 * 
 */
public class IntegrationMovies {
	
	/**
	 * Point d'entrée de l'application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Lecture du JSON
		ObjectMapper mapper = new ObjectMapper();
		FilmDto[] films;
		try {
			films = mapper.readValue(new File(".\\src\\main\\resources\\json\\films.json"), FilmDto[].class);
			for (FilmDto film : films) {
				Film f;
				try {
					f = FilmMapper.toEntity(film);
					System.out.println(f.getNom());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
			}
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}

}
