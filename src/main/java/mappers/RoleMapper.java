package mappers;

import java.text.ParseException;

import org.apache.commons.lang3.StringUtils;

import dto.RoleDto;
import entities.Role;

/**
 * RoleMapper
 */
public class RoleMapper {

	/**
	 * Permet de convertir un RoleDto en Role
	 * 
	 * @param roleDto
	 * @return role
	 * @throws ParseException
	 */
	public static Role toEntity(RoleDto roleDto) throws ParseException {
		Role role = new Role();
		role.setActeur(ActeurMapper.toEntity(roleDto.getActeur()));
		if (StringUtils.isNotBlank(roleDto.getCharacterName())) {
			role.setCharacterName(roleDto.getCharacterName());
		}
		return role;
	}
}
