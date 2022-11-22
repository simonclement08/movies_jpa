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
 * FilmDto
 * 
 * Représente un film (Data Transfert Object)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "pays", "nom", "url", "plot", "langue", "lieuTournage", "realisateurs", "castingPrincipal",
		"anneeSortie", "roles", "genres" })
@Generated("jsonschema2pojo")
public class FilmDto {

	/** id */
	@JsonProperty("id")
	private String id;

	/** pays */
	@JsonProperty("pays")
	private PaysDto pays;

	/** nom */
	@JsonProperty("nom")
	private String nom;

	/** url */
	@JsonProperty("url")
	private String url;

	/** plot Courte description */
	@JsonProperty("plot")
	private Object plot;

	/** langue */
	@JsonProperty("langue")
	private String langue;

	/** lieuTournage Lieu de tournage */
	@JsonProperty("lieuTournage")
	private LieuTournageDto lieuTournage;

	/** realisateurs Liste des réalisateurs */
	@JsonProperty("realisateurs")
	private List<RealisateurDto> realisateurs = new ArrayList<RealisateurDto>();

	/** castingPrincipal Liste des acteurs principaux */
	@JsonProperty("castingPrincipal")
	private List<ActeurDto> castingPrincipal = new ArrayList<ActeurDto>();

	/** anneeSortie Année de sortie */
	@JsonProperty("anneeSortie")
	private String anneeSortie;

	/** roles Liste des rôles */
	@JsonProperty("roles")
	private List<RoleDto> roles = new ArrayList<RoleDto>();

	/** roles Liste des genres */
	@JsonProperty("genres")
	private List<String> genres = new ArrayList<String>();

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
	 * Getter pour l'attribut pays
	 *
	 * @return the pays
	 */
	@JsonProperty("pays")
	public PaysDto getPays() {
		return pays;
	}

	/**
	 * Setter pour l'attribut pays
	 *
	 * @param pays the pays to set
	 */
	@JsonProperty("pays")
	public void setPays(PaysDto pays) {
		this.pays = pays;
	}

	/**
	 * Getter pour l'attribut nom
	 *
	 * @return the nom
	 */
	@JsonProperty("nom")
	public String getNom() {
		return nom;
	}

	/**
	 * Setter pour l'attribut nom
	 *
	 * @param nom the nom to set
	 */
	@JsonProperty("nom")
	public void setNom(String nom) {
		this.nom = nom;
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
	 * Getter pour l'attribut plot
	 *
	 * @return the plot
	 */
	@JsonProperty("plot")
	public Object getPlot() {
		return plot;
	}

	/**
	 * Setter pour l'attribut plot
	 *
	 * @param plot the plot to set
	 */
	@JsonProperty("plot")
	public void setPlot(Object plot) {
		this.plot = plot;
	}

	/**
	 * Getter pour l'attribut langue
	 *
	 * @return the langue
	 */
	@JsonProperty("langue")
	public String getLangue() {
		return langue;
	}

	/**
	 * Setter pour l'attribut langue
	 *
	 * @param langue the langue to set
	 */
	@JsonProperty("langue")
	public void setLangue(String langue) {
		this.langue = langue;
	}

	/**
	 * Getter pour l'attribut lieuTournage
	 *
	 * @return the lieuTournage
	 */
	@JsonProperty("lieuTournage")
	public LieuTournageDto getLieuTournage() {
		return lieuTournage;
	}

	/**
	 * Setter pour l'attribut lieuTournage
	 *
	 * @param lieuTournage the lieuTournage to set
	 */
	@JsonProperty("lieuTournage")
	public void setLieuTournage(LieuTournageDto lieuTournage) {
		this.lieuTournage = lieuTournage;
	}

	/**
	 * Getter pour l'attribut realisateurs
	 *
	 * @return the realisateurs
	 */
	@JsonProperty("realisateurs")
	public List<RealisateurDto> getRealisateurs() {
		return realisateurs;
	}

	/**
	 * Setter pour l'attribut realisateurs
	 *
	 * @param realisateurs the realisateurs to set
	 */
	@JsonProperty("realisateurs")
	public void setRealisateurs(List<RealisateurDto> realisateurs) {
		this.realisateurs = realisateurs;
	}

	/**
	 * Getter pour l'attribut castingPrincipal
	 *
	 * @return the castingPrincipal
	 */
	@JsonProperty("castingPrincipal")
	public List<ActeurDto> getCastingPrincipal() {
		return castingPrincipal;
	}

	/**
	 * Setter pour l'attribut castingPrincipal
	 *
	 * @param castingPrincipal the castingPrincipal to set
	 */
	@JsonProperty("castingPrincipal")
	public void setCastingPrincipal(List<ActeurDto> castingPrincipal) {
		this.castingPrincipal = castingPrincipal;
	}

	/**
	 * Getter pour l'attribut anneeSortie
	 *
	 * @return the anneeSortie
	 */
	@JsonProperty("anneeSortie")
	public String getAnneeSortie() {
		return anneeSortie;
	}

	/**
	 * Setter pour l'attribut anneeSortie
	 *
	 * @param anneeSortie the anneeSortie to set
	 */
	@JsonProperty("anneeSortie")
	public void setAnneeSortie(String anneeSortie) {
		this.anneeSortie = anneeSortie;
	}

	/**
	 * Getter pour l'attribut roles
	 *
	 * @return the roles
	 */
	@JsonProperty("roles")
	public List<RoleDto> getRoles() {
		return roles;
	}

	/**
	 * Setter pour l'attribut roles
	 *
	 * @param roles the roles to set
	 */
	@JsonProperty("roles")
	public void setRoles(List<RoleDto> roles) {
		this.roles = roles;
	}

	/**
	 * Getter pour l'attribut genres
	 *
	 * @return the genres
	 */
	@JsonProperty("genres")
	public List<String> getGenres() {
		return genres;
	}

	/**
	 * Setter pour l'attribut genres
	 *
	 * @param genres the genres to set
	 */
	@JsonProperty("genres")
	public void setGenres(List<String> genres) {
		this.genres = genres;
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
		sb.append(FilmDto.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this)))
				.append('[');
		sb.append("id");
		sb.append('=');
		sb.append(((this.id == null) ? "<null>" : this.id));
		sb.append(',');
		sb.append("pays");
		sb.append('=');
		sb.append(((this.pays == null) ? "<null>" : this.pays));
		sb.append(',');
		sb.append("nom");
		sb.append('=');
		sb.append(((this.nom == null) ? "<null>" : this.nom));
		sb.append(',');
		sb.append("url");
		sb.append('=');
		sb.append(((this.url == null) ? "<null>" : this.url));
		sb.append(',');
		sb.append("plot");
		sb.append('=');
		sb.append(((this.plot == null) ? "<null>" : this.plot));
		sb.append(',');
		sb.append("langue");
		sb.append('=');
		sb.append(((this.langue == null) ? "<null>" : this.langue));
		sb.append(',');
		sb.append("lieuTournage");
		sb.append('=');
		sb.append(((this.lieuTournage == null) ? "<null>" : this.lieuTournage));
		sb.append(',');
		sb.append("realisateurs");
		sb.append('=');
		sb.append(((this.realisateurs == null) ? "<null>" : this.realisateurs));
		sb.append(',');
		sb.append("castingPrincipal");
		sb.append('=');
		sb.append(((this.castingPrincipal == null) ? "<null>" : this.castingPrincipal));
		sb.append(',');
		sb.append("anneeSortie");
		sb.append('=');
		sb.append(((this.anneeSortie == null) ? "<null>" : this.anneeSortie));
		sb.append(',');
		sb.append("roles");
		sb.append('=');
		sb.append(((this.roles == null) ? "<null>" : this.roles));
		sb.append(',');
		sb.append("genres");
		sb.append('=');
		sb.append(((this.genres == null) ? "<null>" : this.genres));
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
		result = ((result * 31) + ((this.lieuTournage == null) ? 0 : this.lieuTournage.hashCode()));
		result = ((result * 31) + ((this.castingPrincipal == null) ? 0 : this.castingPrincipal.hashCode()));
		result = ((result * 31) + ((this.realisateurs == null) ? 0 : this.realisateurs.hashCode()));
		result = ((result * 31) + ((this.anneeSortie == null) ? 0 : this.anneeSortie.hashCode()));
		result = ((result * 31) + ((this.roles == null) ? 0 : this.roles.hashCode()));
		result = ((result * 31) + ((this.langue == null) ? 0 : this.langue.hashCode()));
		result = ((result * 31) + ((this.nom == null) ? 0 : this.nom.hashCode()));
		result = ((result * 31) + ((this.url == null) ? 0 : this.url.hashCode()));
		result = ((result * 31) + ((this.plot == null) ? 0 : this.plot.hashCode()));
		result = ((result * 31) + ((this.genres == null) ? 0 : this.genres.hashCode()));
		result = ((result * 31) + ((this.id == null) ? 0 : this.id.hashCode()));
		result = ((result * 31) + ((this.additionalProperties == null) ? 0 : this.additionalProperties.hashCode()));
		result = ((result * 31) + ((this.pays == null) ? 0 : this.pays.hashCode()));
		return result;
	}

	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if ((other instanceof FilmDto) == false) {
			return false;
		}
		FilmDto rhs = ((FilmDto) other);
		return ((((((((((((((this.lieuTournage == rhs.lieuTournage)
				|| ((this.lieuTournage != null) && this.lieuTournage.equals(rhs.lieuTournage)))
				&& ((this.castingPrincipal == rhs.castingPrincipal)
						|| ((this.castingPrincipal != null) && this.castingPrincipal.equals(rhs.castingPrincipal))))
				&& ((this.realisateurs == rhs.realisateurs)
						|| ((this.realisateurs != null) && this.realisateurs.equals(rhs.realisateurs))))
				&& ((this.anneeSortie == rhs.anneeSortie)
						|| ((this.anneeSortie != null) && this.anneeSortie.equals(rhs.anneeSortie))))
				&& ((this.roles == rhs.roles) || ((this.roles != null) && this.roles.equals(rhs.roles))))
				&& ((this.langue == rhs.langue) || ((this.langue != null) && this.langue.equals(rhs.langue))))
				&& ((this.nom == rhs.nom) || ((this.nom != null) && this.nom.equals(rhs.nom))))
				&& ((this.url == rhs.url) || ((this.url != null) && this.url.equals(rhs.url))))
				&& ((this.plot == rhs.plot) || ((this.plot != null) && this.plot.equals(rhs.plot))))
				&& ((this.genres == rhs.genres) || ((this.genres != null) && this.genres.equals(rhs.genres))))
				&& ((this.id == rhs.id) || ((this.id != null) && this.id.equals(rhs.id))))
				&& ((this.additionalProperties == rhs.additionalProperties) || ((this.additionalProperties != null)
						&& this.additionalProperties.equals(rhs.additionalProperties))))
				&& ((this.pays == rhs.pays) || ((this.pays != null) && this.pays.equals(rhs.pays))));
	}

}
