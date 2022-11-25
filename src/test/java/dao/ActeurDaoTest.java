package dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import entities.Acteur;
import entities.Film;

/**
 * ActeurDaoTest
 *
 * Classe qui teste les méthodes de ActeurDao
 */
public class ActeurDaoTest {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("movies");
	EntityManager em = entityManagerFactory.createEntityManager();
	ActeurDao acteurDao = new ActeurDao(em);
	FilmDao filmDao = new FilmDao(em);

	@Test
	public void testFindByFilm() {
		Film film = filmDao.find("Iron Man");
		List<Acteur> acteurs = acteurDao.findByFilm(film);
		assertEquals(8, acteurs.size());
	}

	@Test
	public void testFindCommunActeur() {
		Film film1 = filmDao.find("Avengers");
		Film film2 = filmDao.find("Avengers: Endgame");
		List<Acteur> acteurs = acteurDao.findCommunActeur(film1, film2);
		assertEquals(4, acteurs.size());
	}
}
