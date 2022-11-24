package service;

import java.util.Scanner;

import javax.persistence.EntityManager;

import exceptions.MenuServiceException;
import manager.FilmManager;

/**
 * MenuService
 *
 * Classe abtraite qui donne un fonctionnement communs aux différents services
 */
public abstract class MenuService {

	/** em Entity Manager */
	protected EntityManager em;
	
	/**
	 * Constructeur
	 *
	 */
	public MenuService() {
		super();
		em = FilmManager.getInstance().getEm();
	}

	/**
	 * Permet de traiter les données insérer en base
	 * 
	 * @param scanner
	 * @throws MenuServiceException 
	 */
	public abstract void traiter(Scanner scanner) throws MenuServiceException;

	/**
	 * Permet d'afficher un message afin de faire fonctionner les services
	 * 
	 * @param scanner
	 * @param message
	 * @return le choix de l'utilisateur
	 */
	public static String afficherMessage(Scanner scanner, String message) {
		System.out.println("Veuillez renseigner " + message);
		return scanner.nextLine();
	}

}
