package dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import entities.Acteur;
import entities.Film;

/**
 * FilmDaoTest
 *
 * Classe qui teste les méthodes de FilmDao
 */
public class FilmDaoTest {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("movies");
	EntityManager em = entityManagerFactory.createEntityManager();
	FilmDao filmDao = new FilmDao(em);
	ActeurDao acteurDao = new ActeurDao(em);

	@Test
	public void testFindByActeur() {
		Acteur acteur = acteurDao.find("Chris Pratt");
		List<Film> films = filmDao.findByActeur(acteur);
		assertEquals(44, films.size());
	}

	@Test
	public void testFindBetweenYears() {
		List<Film> films = filmDao.findBetweenYears(2009, 2010);
		assertEquals(109, films.size());
	}

	@Test
	public void testFindCommunFilm() {
		Acteur acteur1 = acteurDao.find("Robert Downey Jr.");
		Acteur acteur2 = acteurDao.find("Chris Evans");
		List<Film> films = filmDao.findCommunFilm(acteur1, acteur2);
		assertEquals(5, films.size());
	}
}
