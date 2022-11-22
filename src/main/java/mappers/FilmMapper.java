package mappers;

import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;

import dto.ActeurDto;
import dto.FilmDto;
import dto.RealisateurDto;
import dto.RoleDto;
import entities.Film;
import entities.Genre;
import entities.Langue;

/**
 * FilmMapper
 */
public class FilmMapper {

	/**
	 * Permet de convertir un FilmDto en Film
	 * 
	 * @param filmDto
	 * @return film
	 * @throws ParseException
	 */
	public static Film toEntity(FilmDto filmDto) throws ParseException {
		Film film = new Film();

		film.setId(filmDto.getId());
		film.setNom(filmDto.getNom());
		film.setUrl(filmDto.getUrl());

		if (filmDto.getPlot() != null && StringUtils.isNotBlank(filmDto.getPlot().toString())) {
			film.setPlot(filmDto.getPlot().toString());
		}

		if (StringUtils.isNotBlank(filmDto.getAnneeSortie().toString())) {
			film.setAnneeSortie(Integer.parseInt(filmDto.getAnneeSortie().substring(0, 4)));
		}

		film.setLangue(new Langue(filmDto.getLangue()));

		for (String genre : filmDto.getGenres()) {
			if (StringUtils.isNotBlank(genre)) {
				Genre newGenre = new Genre(genre);
				film.getGenres().add(newGenre);
			}
		}

		if (filmDto.getPays() != null) {
			film.setPays(PaysMapper.toEntity(filmDto.getPays()));
		}

		if (filmDto.getLieuTournage() != null) {
			film.setLieuTournage(LieuTournageMapper.toEntity(filmDto.getLieuTournage()));
		}

		for (RealisateurDto realisateurDto : filmDto.getRealisateurs()) {
			film.getRealisateurs().add(RealisateurMapper.toEntity(realisateurDto));
		}

		for (ActeurDto acteurDto : filmDto.getCastingPrincipal()) {
			film.getCastingPrincipal().add(ActeurMapper.toEntity(acteurDto));
		}

		for (RoleDto roleDto : filmDto.getRoles()) {
			film.getRoles().add(RoleMapper.toEntity(roleDto));
		}

		return film;
	}
}
