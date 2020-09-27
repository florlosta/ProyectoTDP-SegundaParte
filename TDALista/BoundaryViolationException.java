package TDALista;

/**
 * Modela una situaci�n de error en la que nos excedemos de los l�mites de una lista.
 */
public class BoundaryViolationException extends Exception {
	/**
	 * Inicializa la BoundaryViolationException con el mensaje pasado por par�metro.
	 * @param mensaje, descripci�n de la situaci�n que produjo un error.  
	 */
	public BoundaryViolationException (String mensaje) {
		super (mensaje);
	}

}
