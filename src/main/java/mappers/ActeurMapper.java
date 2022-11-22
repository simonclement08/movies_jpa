package mappers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

import dto.ActeurDto;
import entities.Acteur;
import entities.Lieu;
import entities.Pays;

/**
 * ActeurMapper
 */
public class ActeurMapper {

	/**
	 * Permet de convertir un ActeurDto en Acteur
	 * 
	 * @param acteurDto
	 * @return acteur
	 * @throws ParseException
	 */
	public static Acteur toEntity(ActeurDto acteurDto) throws ParseException {
		Acteur acteur = new Acteur(acteurDto.getId(), acteurDto.getIdentite(), acteurDto.getUrl());

		if (acteurDto.getHeight() != null) {
			acteur.setHeight(Double.parseDouble(acteurDto.getHeight().toString()));
		}
		if (acteurDto.getNaissance() != null) {

			if (acteurDto.getNaissance().getDateNaissance() != null
					&& StringUtils.isNotBlank(acteurDto.getNaissance().getDateNaissance())) {
				Date date = new SimpleDateFormat("yyyy-M-d").parse(acteurDto.getNaissance().getDateNaissance());
				acteur.setDateNaissance(date);
			}

			if (acteurDto.getNaissance().getLieuNaissance() != null
					&& StringUtils.isNotBlank(acteurDto.getNaissance().getLieuNaissance())) {
				String[] lieu = acteurDto.getNaissance().getLieuNaissance().split(",");
				Lieu lieuNaissance = new Lieu();
				lieuNaissance.setPays(new Pays(lieu[lieu.length - 1]));
				if (lieu.length >= 2 && StringUtils.isNotBlank(lieu[lieu.length - 2])) {
					lieuNaissance.setEtatDept(lieu[lieu.length - 2]);
				}
				if (lieu.length >= 3 && StringUtils.isNotBlank(lieu[lieu.length - 3])) {
					lieuNaissance.setVille(lieu[lieu.length - 3]);
				}
				acteur.setLieuNaissance(lieuNaissance);
			}
		}

		return acteur;
	}
}
