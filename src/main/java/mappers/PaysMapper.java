package mappers;

import dto.PaysDto;
import entities.Pays;

/**
 * PaysMapper
 */
public class PaysMapper {

	/**
	 * Permet de convertir un PaysDto en Pays
	 * 
	 * @param paysDto
	 * @return pays
	 */
	public static Pays toEntity(PaysDto paysDto) {

		Pays pays = new Pays(paysDto.getNom());
		pays.setUrl(paysDto.getUrl());

		return pays;
	}
}
