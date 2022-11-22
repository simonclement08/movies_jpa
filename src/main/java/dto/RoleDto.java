package dto;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * RoleDto
 * 
 * Représente un rôle (Data Transfert Object)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "characterName", "acteur", "film" })
@Generated("jsonschema2pojo")
public class RoleDto {

	/** characterName Nom du personnage */
	@JsonProperty("characterName")
	private String characterName;

	/** acteur Acteur */
	@JsonProperty("acteur")
	private ActeurDto acteur;

	/** film Film */
	@JsonProperty("film")
	private String film;

	/** additionalProperties */
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	/**
	 * Getter pour l'attribut characterName
	 *
	 * @return the characterName
	 */
	@JsonProperty("characterName")
	public String getCharacterName() {
		return characterName;
	}

	/**
	 * Setter pour l'attribut characterName
	 *
	 * @param characterName the characterName to set
	 */
	@JsonProperty("characterName")
	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	/**
	 * Getter pour l'attribut acteur
	 *
	 * @return the acteur
	 */
	@JsonProperty("acteur")
	public ActeurDto getActeur() {
		return acteur;
	}

	/**
	 * Setter pour l'attribut acteur
	 *
	 * @param acteur the acteur to set
	 */
	@JsonProperty("acteur")
	public void setActeur(ActeurDto acteur) {
		this.acteur = acteur;
	}

	/**
	 * Getter pour l'attribut film
	 *
	 * @return the film
	 */
	@JsonProperty("film")
	public String getFilm() {
		return film;
	}

	/**
	 * Setter pour l'attribut film
	 *
	 * @param film the film to set
	 */
	@JsonProperty("film")
	public void setFilm(String film) {
		this.film = film;
	}

	/**
	 * Getter pour l'attribut additionalProperties
	 *
	 * @return the additionalProperties
	 */
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	/**
	 * Setter pour l'attribut additionalProperties
	 *
	 * @param additionalProperties the additionalProperties to set
	 */
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(RoleDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("characterName");
		sb.append('=');
		sb.append(((this.characterName == null) ? "<null>" : this.characterName));
		sb.append(',');
		sb.append("acteur");
		sb.append('=');
		sb.append(((this.acteur == null) ? "<null>" : this.acteur));
		sb.append(',');
		sb.append("film");
		sb.append('=');
		sb.append(((this.film == null) ? "<null>" : this.film));
		sb.append(',');
		sb.append("additionalProperties");
		sb.append('=');
		sb.append(((this.additionalProperties == null) ? "<null>" : this.additionalProperties));
		sb.append(',');
		if (sb.charAt((sb.length() - 1)) == ',') {
			sb.setCharAt((sb.length() - 1), ']');
		} else {
			sb.append(']');
		}
		return sb.toString();
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = ((result * 31) + ((this.characterName == null) ? 0 : this.characterName.hashCode()));
		result = ((result * 31) + ((this.film == null) ? 0 : this.film.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.acteur == null) ? 0 : this.acteur.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof RoleDto) == false) {
			return false;
		}
		RoleDto rhs = ((RoleDto) other);
		return (((((this.characterName == rhs.characterName)
				|| ((this.characterName != null) && this.characterName.equals(rhs.characterName)))
				&& ((this.film == rhs.film) || ((this.film != null) && this.film.equals(rhs.film))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.acteur == rhs.acteur) || ((this.acteur != null) && this.acteur.equals(rhs.acteur))));
	}

}
