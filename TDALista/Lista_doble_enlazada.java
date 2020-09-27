package TDALista;
import java.util.Iterator;

/**
 * Clase lista doble enlazada: Implementa los datos y operaciones aplicables sobre una lista.
 * @author Flor Loustaunau.
 *
 * @param <E> Tipo de dato de los elementos a almacenar en la lista.
 */
public class Lista_doble_enlazada<E> implements PositionList<E> {
	protected int size;
	protected DNodo<E> header, trailer; 
 
	/**
	 * Crea inicialmente una lista vacia con dos nodos centinelas. 
	 */
	public Lista_doble_enlazada() {
		size=0;
		header = new DNodo<E>(null, null,null); //crea la cabeza
		trailer = new DNodo<E>(header, null, null); //crea la cola
		header.setNext(trailer);    //hace que la cabeza y la cola se referencien entre si
	}
		
	/**
	 * Chequea si la posicion es valida para esta lista, y la convierte a DNodo si es valido
	 * @return DNodo <E>, el nodo retornado si la posicion es valida
	 */
	protected DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException {
		if (p==null) 
			throw new InvalidPositionException ("Posicion nula en DNodo ");
		if (p==header) 
			throw new InvalidPositionException("El nodo de la cabeza no es una posicion valida ");
		if (p==trailer)
			throw new InvalidPositionException("El nodo de la cola no es una posicion valida");
		
		try {
			DNodo<E> temp = (DNodo<E>) p;
			if ((temp.getPrev()==null) || (temp.getNext()==null))
				throw new InvalidPositionException("La posicion no corresponde a un nodo valido ");
		return temp;
		
		}catch (ClassCastException e ) {
			throw new InvalidPositionException(" El tipo es erroneo para esta lista ");
		}
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return (size==0);
		
	}

	@Override
	public Position<E> first() throws EmptyListException {
		if (size == 0) 
			throw new EmptyListException(" La lista esta vacia ");
		return header.getNext();
		
	}
	
	@Override
	public Position<E> prev (Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> v = checkPosition(p);
		DNodo<E> prev = v.getPrev();
		if (prev==header)
			throw new BoundaryViolationException (" El elemento no esta dentro de los limites de la lista ");
		return prev;
	}
	
	@Override
	public void addBefore (Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> v = checkPosition(p);
		size++;
		DNodo<E> newNodo = new DNodo<E>(v.getPrev(), v, element);
		v.getPrev().setNext(newNodo);
		v.setPrev(newNodo);
	}
	
	@Override
	public void addFirst(E element) {
		size++;
		DNodo<E> newNodo = new DNodo<E> (header, header.getNext(),element);
		header.getNext().setPrev(newNodo);
		header.setNext(newNodo);
	}
	

	@Override
	public E remove(Position<E> p) throws InvalidPositionException {
	      DNodo<E> nodo = this.checkPosition(p);
	      E elemento = nodo.element();
	      nodo.getPrev().setNext(nodo.getNext());
	      nodo.getNext().setPrev(nodo.getPrev());
	      
	      nodo.setElement(null);
	      nodo.setNext(null);
	      nodo.setPrev(null);
	      size--;
	      return elemento;
	   }	
		
	@Override
	public E set(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> v = checkPosition(p);
		E elemento = v.element();
		v.setElement(element);
		return elemento;
	}

	@Override
	public Position<E> last() throws EmptyListException {
		if (size == 0) {
			throw new EmptyListException(" Se utilizo last en una lista vacia");
		}else {
			return trailer.getPrev();
		}
	}

	@Override
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException {
		DNodo<E> nodo = checkPosition(p);
		if (nodo.getNext() == trailer) {
			throw new BoundaryViolationException (" Error sobre la ultima posicion de la lista");
		}else {
			return nodo.getNext();
		}

	}

	@Override
	public void addLast(E element) {
		DNodo<E> nuevo = new DNodo<E>(trailer.getPrev(), trailer, element);
		trailer.getPrev().setNext(nuevo);
		trailer.setPrev(nuevo);
		size++;
		
	}


	@Override
	public void addAfter(Position<E> p, E element) throws InvalidPositionException {
		DNodo<E> pos = checkPosition(p);
		DNodo<E> nuevo = new DNodo<E>(element);
		nuevo.setNext(pos.getNext());
		nuevo.setPrev(pos);
		nuevo.getNext().setPrev(nuevo);
		pos.setNext(nuevo);
		size++;
	}

	@Override
	public Iterator<E> iterator() {
		return new ElementIterator<E>(this);
	}

	@Override
	public Iterable<Position<E>> positions() {
		PositionList<Position<E>> lista = new Lista_doble_enlazada<Position<E>>();
		if (size !=0) {
			recorrerPosiciones(lista, header.getNext());
		}
		return lista;
	}
	
	/**
	 * Método auxilar que recorre cada una de las posiciones de la lista.
	 * @param lista, PositionList a recorrer.
	 * @param nodo, primer nodo no dummie de la PositionList a recorrer.
	 */
	private void recorrerPosiciones (PositionList<Position<E>> lista, DNodo<E> nodo) {
		lista.addLast(nodo);
		if (nodo.getNext()!= trailer) {
			recorrerPosiciones(lista, nodo.getNext());
		}
	}
	
	public String toString() {
		String cad = " ";
		
		for (Position<E> pos: this.positions()) {
			cad = cad + pos.element().toString();
		}
		return cad;
	}
	
}


