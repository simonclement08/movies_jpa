package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.Lieu;
import entities.Pays;

/**
 * LieuDao
 *
 * Gère la persistance des lieux
 *
 */
public class LieuDao extends AbstractDao<Lieu> {

	/**
	 * Constructeur
	 * 
	 * @param em entityManager
	 */
	public LieuDao(EntityManager em) {
		super(em, Lieu.class);
	}

	/**
	 * Extrait un lieu de la base en fonction de la ville, l'état/département et le
	 * pays, ou retourne null si le lieu n'existe pas.
	 * 
	 * @param ville
	 * @param identite
	 * @param pays
	 * @return Lieu
	 */
	public Lieu find(String ville, String etatDpt, Pays pays) {
		TypedQuery<Lieu> query = 
				em.createQuery("SELECT l FROM " + classe.getSimpleName() + " l "
				+ "JOIN l.pays p "
				+ "WHERE l.ville = :ville "
				+ "AND l.etatDept = :etat "
				+ "AND p.id = :pays", classe);
		query.setParameter("ville", ville);
		query.setParameter("etat", etatDpt);
		query.setParameter("pays", pays.getId());

		List<Lieu> results = query.getResultList();
		if (results.isEmpty()) {
			return null;
		}

		return results.get(0);
	}
}
