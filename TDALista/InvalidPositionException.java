package TDALista;

/**
 * Modela una situaci�n de error en la que accedemos a una posici�n inv�lida de una lista.
 */
public class InvalidPositionException extends Exception {
	/**
	 * Inicializa la InvalidPositionException con el mensaje pasado por par�metro.
	 * @param mensaje, descripci�n de la situaci�n que produjo un error.  
	 */
	public InvalidPositionException (String mensaje) {
		super(mensaje);
	}

}
