package TDALista;

/**
 * Modela una situación de error en la que nos excedemos de los límites de una lista.
 */
public class BoundaryViolationException extends Exception {
	/**
	 * Inicializa la BoundaryViolationException con el mensaje pasado por parámetro.
	 * @param mensaje, descripción de la situación que produjo un error.  
	 */
	public BoundaryViolationException (String mensaje) {
		super (mensaje);
	}

}
