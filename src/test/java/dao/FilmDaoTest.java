package dao;

import static org.junit.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import entities.Acteur;
import entities.Film;

public class FilmDaoTest {
	
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("movies");
	EntityManager em = entityManagerFactory.createEntityManager();

	@Test
	public void testFindByActeur() {
		FilmDao filmDao = new FilmDao(em);
		ActeurDao acteurDao = new ActeurDao(em);
		Acteur acteur = acteurDao.find("Chris Pratt");
		List<Film> films = filmDao.findByActeur(acteur);
		assertEquals(44, films.size());
	}
	
	@Test
	public void findBetweenYears() {
		FilmDao filmDao = new FilmDao(em);
		List<Film> films = filmDao.findBetweenYears(2009,2010);
		assertEquals(109, films.size());
	}
}
