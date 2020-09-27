package TDALista;

/**
 * Clase DNodo: implementa los metodos y datos de DNodo<E> para la lista doblemente enlazada.
 * @author Flor Loustaunau.
 *
 * @param <E> Tipo de dato de los elementos de la clase DNodo.
 */
public class DNodo<E> implements Position<E> {
	private DNodo<E> prev, next; //Referencias al nodo antes y despues
	private E element;

	/**
	 * Crea un nuevo nodo con referencia al nodo anterior, al siguiente y establece el valor del elemento del nodo.
	 * @param newPrev nodo anterior.
	 * @param newNext nodo siguiente.
	 * @param elem, elemento del nodo.
	 */
	public DNodo(DNodo<E> newPrev, DNodo<E> newNext, E elem) {
		prev=newPrev;
		next=newNext;
		element=elem;
	}
	
	
	/**
	 * Crea un nuevo nodo sin referencia a otros nodos, solo con el elemento.
	 * @param elem, elemento del nuevo nodo.
	 */
	public DNodo(E elem) {
		prev=null;
		next=null;
		element = elem;
	}

	/**
	 * Retorna el valor almacenado en el nodo.
	 * @return E, elemento del nodo.
	 */
	public E element() {
		return element;
	}
	
	//metodos de acceso
	/**
	 * Retorna el nodo siguiente enlazado.  
	 * @return DNodo<E> nodo siguiente.
	 */
	public DNodo<E> getNext() {
		return next;
	}
	
	/**
	 * Retorna el nodo anterior enlazado.
	 * @return DNodo<E> nodo anterior.
	 */
	public DNodo<E> getPrev() {
		return prev;
	}
	
	//metodos para actualizar
	 
	/**
	 * Setea el nodo siguiente al pasado por parámetro.
	 * @param newNext nodo siguiente a ser seteado.
	 */
	public void setNext(DNodo<E> newNext) {
		next=newNext;
	}
	
	/**
	 * Setea el nodo anterior al pasado parámetro.
	 * @param newPrev nodo anterior a ser seteado.
	 */
	public void setPrev( DNodo<E> newPrev) {
		prev= newPrev;
	}
	
	/**
	 * Setea el elemento del nodo.
	 * @param newElement elemento del nodo. 
	 */
	public void setElement(E newElement) {
		element= newElement;
	}

	public String toString () {
		return element.toString();
	}
}