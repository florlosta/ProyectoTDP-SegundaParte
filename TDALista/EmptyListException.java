package TDALista;

/**
 * Modela una situación de error en la que intentamos manipular una lista vacía.
 */
public class EmptyListException extends Exception {
	/**
	 * Inicializa la EmptyListException con el mensaje pasado por parámetro.
	 * @param mensaje, descripción de la situación que produjo un error.  
	 */
	public EmptyListException (String mensaje) {
		super (mensaje);
	}

}
