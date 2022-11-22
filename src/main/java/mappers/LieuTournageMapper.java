package mappers;

import dto.LieuTournageDto;
import entities.Lieu;
import entities.Pays;

/**
 * LieuTournageMapper
 */
public class LieuTournageMapper {

	/**
	 * Permet de convertir un LieuTournageDto en Lieu
	 * 
	 * @param lieuTournageDto
	 * @return lieu
	 */
	public static Lieu toEntity(LieuTournageDto lieuTournageDto) {
		Lieu lieu = new Lieu(lieuTournageDto.getVille(), lieuTournageDto.getEtatDept(),
				new Pays(lieuTournageDto.getPays()));

		return lieu;
	}
}
