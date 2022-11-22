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
 * LieuTournageDto
 * 
 * Représente un lieu de tournage (Data Transfert Object)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "ville", "etatDept", "pays" })
@Generated("jsonschema2pojo")
public class LieuTournageDto {

	/** ville */
	@JsonProperty("ville")
	private String ville;

	/** etatDept Etat ou Département */
	@JsonProperty("etatDept")
	private String etatDept;

	/** pays */
	@JsonProperty("pays")
	private String pays;

	/** additionalProperties */
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	/**
	 * Getter pour l'attribut ville
	 *
	 * @return the ville
	 */
	@JsonProperty("ville")
	public String getVille() {
		return ville;
	}

	/**
	 * Setter pour l'attribut ville
	 *
	 * @param ville the ville to set
	 */
	@JsonProperty("ville")
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Getter pour l'attribut etatDept
	 *
	 * @return the etatDept
	 */
	@JsonProperty("etatDept")
	public String getEtatDept() {
		return etatDept;
	}

	/**
	 * Setter pour l'attribut etatDept
	 *
	 * @param etatDept the etatDept to set
	 */
	@JsonProperty("etatDept")
	public void setEtatDept(String etatDept) {
		this.etatDept = etatDept;
	}

	/**
	 * Getter pour l'attribut pays
	 *
	 * @return the pays
	 */
	@JsonProperty("pays")
	public String getPays() {
		return pays;
	}

	/**
	 * Setter pour l'attribut pays
	 *
	 * @param pays the pays to set
	 */
	@JsonProperty("pays")
	public void setPays(String pays) {
		this.pays = pays;
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
		sb.append(LieuTournageDto.class.getName()).append('@')
				.append(Integer.toHexString(System.identityHashCode(this))).append('[');
		sb.append("ville");
		sb.append('=');
		sb.append(((this.ville == null) ? "<null>" : this.ville));
		sb.append(',');
		sb.append("etatDept");
		sb.append('=');
		sb.append(((this.etatDept == null) ? "<null>" : this.etatDept));
		sb.append(',');
		sb.append("pays");
		sb.append('=');
		sb.append(((this.pays == null) ? "<null>" : this.pays));
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
		result = ((result * 31) + ((this.ville == null) ? 0 : this.ville.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.etatDept == null) ? 0 : this.etatDept.hashCode()));
		result = ((result * 31) + ((this.pays == null) ? 0 : this.pays.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof LieuTournageDto) == false) {
			return false;
		}
		LieuTournageDto rhs = ((LieuTournageDto) other);
		return (((((this.ville == rhs.ville) || ((this.ville != null) && this.ville.equals(rhs.ville)))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.etatDept == rhs.etatDept) || ((this.etatDept != null) && this.etatDept.equals(rhs.etatDept))))
				&& ((this.pays == rhs.pays) || ((this.pays != null) && this.pays.equals(rhs.pays))));
	}

}
