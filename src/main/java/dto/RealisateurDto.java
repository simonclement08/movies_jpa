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
 * RealisateurDto
 * 
 * Représente un réalisateur (Data Transfert Object)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "identite", "url" })
@Generated("jsonschema2pojo")
public class RealisateurDto {

	/** identite */
	@JsonProperty("identite")
	private String identite;

	/** url */
	@JsonProperty("url")
	private String url;

	/** additionalProperties */
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	/**
	 * Getter pour l'attribut identite
	 *
	 * @return the identite
	 */
	@JsonProperty("identite")
	public String getIdentite() {
		return identite;
	}

	/**
	 * Setter pour l'attribut identite
	 *
	 * @param identite the identite to set
	 */
	@JsonProperty("identite")
	public void setIdentite(String identite) {
		this.identite = identite;
	}

	/**
	 * Getter pour l'attribut url
	 *
	 * @return the url
	 */
	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	/**
	 * Setter pour l'attribut url
	 *
	 * @param url the url to set
	 */
	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
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
		sb.append(RealisateurDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("identite");
		sb.append('=');
		sb.append(((this.identite == null) ? "<null>" : this.identite));
		sb.append(',');
		sb.append("url");
		sb.append('=');
		sb.append(((this.url == null) ? "<null>" : this.url));
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
		result = ((result * 31) + ((this.identite == null) ? 0 : this.identite.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.url == null) ? 0 : this.url.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof RealisateurDto) == false) {
			return false;
		}
		RealisateurDto rhs = ((RealisateurDto) other);
		return ((((this.identite == rhs.identite) || ((this.identite != null) && this.identite.equals(rhs.identite)))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.url == rhs.url) || ((this.url != null) && this.url.equals(rhs.url))));
	}

}
