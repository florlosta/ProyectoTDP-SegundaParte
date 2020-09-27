package TDALista;

/**
 * Interfaz que define los metodos aplicables sobre una Position<E>.
 * @author Flor Loustaunau.
 *
 * @param <E> Tipo de dato de los elementos a almacenar en la posici�n.
 */
public interface Position <E> {
	
	/**
	 * Retorna el elemento almacenado en la posici�n.
	 * @return E, elemento almacenado. 
	 */
	public E element();
}
