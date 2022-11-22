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
 * NaissanceDto
 * 
 * Informations sur la naissance d'un acteur (Data Transfert Object)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "dateNaissance", "lieuNaissance" })
@Generated("jsonschema2pojo")
public class NaissanceDto {

	/** dateNaissance Date de naissance */
	@JsonProperty("dateNaissance")
	private String dateNaissance;

	/** lieuNaissance Lieu de naissance */
	@JsonProperty("lieuNaissance")
	private String lieuNaissance;

	/** additionalProperties */
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	/**
	 * Getter pour l'attribut dateNaissance
	 *
	 * @return the dateNaissance
	 */
	@JsonProperty("dateNaissance")
	public String getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Setter pour l'attribut dateNaissance
	 *
	 * @param dateNaissance the dateNaissance to set
	 */
	@JsonProperty("dateNaissance")
	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Getter pour l'attribut lieuNaissance
	 *
	 * @return the lieuNaissance
	 */
	@JsonProperty("lieuNaissance")
	public String getLieuNaissance() {
		return lieuNaissance;
	}

	/**
	 * Setter pour l'attribut lieuNaissance
	 *
	 * @param lieuNaissance the lieuNaissance to set
	 */
	@JsonProperty("lieuNaissance")
	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
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
		sb.append(NaissanceDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("dateNaissance");
		sb.append('=');
		sb.append(((this.dateNaissance == null) ? "<null>" : this.dateNaissance));
		sb.append(',');
		sb.append("lieuNaissance");
		sb.append('=');
		sb.append(((this.lieuNaissance == null) ? "<null>" : this.lieuNaissance));
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
		result = ((result * 31) + ((this.lieuNaissance == null) ? 0 : this.lieuNaissance.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.dateNaissance == null) ? 0 : this.dateNaissance.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof NaissanceDto) == false) {
			return false;
		}
		NaissanceDto rhs = ((NaissanceDto) other);
		return ((((this.lieuNaissance == rhs.lieuNaissance)
				|| ((this.lieuNaissance != null) && this.lieuNaissance.equals(rhs.lieuNaissance)))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.dateNaissance == rhs.dateNaissance)
						|| ((this.dateNaissance != null) && this.dateNaissance.equals(rhs.dateNaissance))));
	}

}
