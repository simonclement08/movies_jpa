package dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * ActeurDto
 * 
 * Représente un acteur (Data Transfert Object)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "identite", "naissance", "url", "height", "roles" })
@Generated("jsonschema2pojo")
public class ActeurDto {

	/** id */
	@JsonProperty("id")
	private String id;

	/** identite */
	@JsonProperty("identite")
	private String identite;

	/** naissance Information sur la naissance de l'acteur */
	@JsonProperty("naissance")
	private NaissanceDto naissance;

	/** url */
	@JsonProperty("url")
	private String url;

	/** height Taille */
	@JsonProperty("height")
	private Object height;

	/** roles Liste des rôles */
	@JsonProperty("roles")
	private List<Object> roles = new ArrayList<Object>();

	/** additionalProperties */
	@JsonIgnore
	private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

	/**
	 * Getter pour l'attribut id
	 *
	 * @return the id
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 * Setter pour l'attribut id
	 *
	 * @param id the id to set
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

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
	 * Getter pour l'attribut naissance
	 *
	 * @return the naissance
	 */
	@JsonProperty("naissance")
	public NaissanceDto getNaissance() {
		return naissance;
	}

	/**
	 * Setter pour l'attribut naissance
	 *
	 * @param naissance the naissance to set
	 */
	@JsonProperty("naissance")
	public void setNaissance(NaissanceDto naissance) {
		this.naissance = naissance;
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
	 * Getter pour l'attribut height
	 *
	 * @return the height
	 */
	@JsonProperty("height")
	public Object getHeight() {
		return height;
	}

	/**
	 * Setter pour l'attribut height
	 *
	 * @param height the height to set
	 */
	@JsonProperty("height")
	public void setHeight(Object height) {
		this.height = height;
	}

	/**
	 * Getter pour l'attribut roles
	 *
	 * @return the roles
	 */
	@JsonProperty("roles")
	public List<Object> getRoles() {
		return roles;
	}

	/**
	 * Setter pour l'attribut roles
	 *
	 * @param roles the roles to set
	 */
	@JsonProperty("roles")
	public void setRoles(List<Object> roles) {
		this.roles = roles;
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
		sb.append(ActeurDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("identite");
		sb.append('=');
		sb.append(((this.identite == null) ? "<null>" : this.identite));
		sb.append(',');
		sb.append("naissance");
		sb.append('=');
		sb.append(((this.naissance == null) ? "<null>" : this.naissance));
		sb.append(',');
		sb.append("url");
		sb.append('=');
		sb.append(((this.url == null) ? "<null>" : this.url));
		sb.append(',');
		sb.append("height");
		sb.append('=');
		sb.append(((this.height == null) ? "<null>" : this.height));
		sb.append(',');
		sb.append("roles");
		sb.append('=');
		sb.append(((this.roles == null) ? "<null>" : this.roles));
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
		result = ((result * 31) + ((this.naissance == null) ? 0 : this.naissance.hashCode()));
		result = ((result * 31) + ((this.roles == null) ? 0 : this.roles.hashCode()));
		result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.url == null) ? 0 : this.url.hashCode()));
		result = ((result * 31) + ((this.height == null) ? 0 : this.height.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof ActeurDto) == false) {
			return false;
		}
		ActeurDto rhs = ((ActeurDto) other);
		return ((((((((this.identite == rhs.identite)
				|| ((this.identite != null) && this.identite.equals(rhs.identite)))
				&& ((this.naissance == rhs.naissance)
						|| ((this.naissance != null) && this.naissance.equals(rhs.naissance))))
				&& ((this.roles == rhs.roles) || ((this.roles != null) && this.roles.equals(rhs.roles))))
				&& ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.url == rhs.url) || ((this.url != null) && this.url.equals(rhs.url))))
				&& ((this.height == rhs.height) || ((this.height != null) && this.height.equals(rhs.height))));
	}

}
