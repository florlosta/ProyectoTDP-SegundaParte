package TDALista;

/**
 * Modela una situación de error en la que accedemos a una posición inválida de una lista.
 */
public class InvalidPositionException extends Exception {
	/**
	 * Inicializa la InvalidPositionException con el mensaje pasado por parámetro.
	 * @param mensaje, descripción de la situación que produjo un error.  
	 */
	public InvalidPositionException (String mensaje) {
		super(mensaje);
	}

}
