package io;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.FilmDto;
import entities.Film;
import mappers.FilmMapper;

/** Classe Reader */
public final class Reader {

	/** Instance */
	private final static Reader instance = new Reader();

	/** Constructeur */
	private Reader() {
		super();
	}

	/**
	 * Retourne la liste des films stockées dans le fichier JSON
	 * 
	 * @param src Chemin du fichier JSON
	 * @return List<FilmDto>
	 * @throws IOException
	 * @throws DatabindException
	 * @throws StreamReadException
	 * @throws ParseException
	 */
	public List<Film> getFilmDtos(String src)
			throws StreamReadException, DatabindException, IOException, ParseException {
		ObjectMapper mapper = new ObjectMapper();
		FilmDto[] filmDtos = mapper.readValue(new File(src), FilmDto[].class);
		List<Film> films = new ArrayList<Film>();
		for (FilmDto filmDto : filmDtos) {
			films.add(FilmMapper.toEntity(filmDto));
		}
		return films;
	}

	/**
	 * Getter pour l'attribut instance
	 *
	 * @return the instance
	 */
	public final static Reader getInstance() {
		return Reader.instance;
	}

}
