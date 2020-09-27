package TDALista;

/**
 * Modela una situaci�n de error en la que intentamos manipular una lista vac�a.
 */
public class EmptyListException extends Exception {
	/**
	 * Inicializa la EmptyListException con el mensaje pasado por par�metro.
	 * @param mensaje, descripci�n de la situaci�n que produjo un error.  
	 */
	public EmptyListException (String mensaje) {
		super (mensaje);
	}

}
