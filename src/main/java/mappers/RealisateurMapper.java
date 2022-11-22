package mappers;

import java.util.UUID;

import dto.RealisateurDto;
import entities.Realisateur;

/**
 * RealisateurMapper
 */
public class RealisateurMapper {

	/**
	 * Permet de convertir un RealisateurDto en Realisateur
	 * 
	 * @param realisateurDto
	 * @return realisateur
	 */
	public static Realisateur toEntity(RealisateurDto realisateurDto) {
		UUID uuid = UUID.randomUUID();
		Realisateur realisateur = new Realisateur(uuid.toString(), realisateurDto.getIdentite(),
				realisateurDto.getUrl());
		return realisateur;
	}

}
