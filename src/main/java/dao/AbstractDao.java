package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 * AbstractDao
 * 
 * Classe mère des DAO
 * 
 */
public abstract class AbstractDao<T> {

	/** entityManager */
	protected EntityManager em;

	/** Classe de l'entité */
	protected Class<T> classe;

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public AbstractDao(EntityManager em, Class<T> classe) {
		super();
		this.em = em;
		this.classe = classe;
	}

	/**
	 * Insère une nouvelle entité en base de données
	 * 
	 * @param entite entité
	 */
	public void insert(T entite) {
		em.persist(entite);
	}

	/**
	 * Extrait une entité de la base en fonction de son nom, ou retourne null si
	 * l'entité n'existe pas.
	 * 
	 * @param nom nom de l'entité
	 * @return T
	 */
	public T find(String nom) {

		TypedQuery<T> query = em.createQuery("FROM " + classe.getSimpleName() + " WHERE nom = :nom", classe);
		query.setParameter("nom", nom);

		List<T> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}

	/**
	 * Getter pour l'attribut em
	 *
	 * @return the em
	 */
	public EntityManager getEm() {
		return em;
	}

	/**
	 * Getter pour l'attribut classe
	 *
	 * @return the classe
	 */
	public Class<T> getClasse() {
		return classe;
	}
}
