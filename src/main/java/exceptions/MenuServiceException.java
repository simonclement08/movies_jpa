package exceptions;

/**
 * MenuServiceException
 */
public class MenuServiceException extends Exception {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur
	 *
	 * @param message
	 */
	public MenuServiceException(String message) {
		super(message);
	}
}
