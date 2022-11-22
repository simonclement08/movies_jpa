package io;

/** Classe Reader */
public final class Reader {

	/** Instance */
	private final static Reader instance = new Reader();

	/** Constructeur */
	private Reader() {
		super();
	}

	/**
	 * Getter pour l'attribut instance
	 *
	 * @return the instance
	 */
	public final static Reader getInstance() {
		return Reader.instance;
	}

}
