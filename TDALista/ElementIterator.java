package TDALista;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Clase ElementIterator: implementa los métodos para recorrer una ED iterable, el cual queda definido através de un iterador.
 * @author Flor Loustaunau.
 * 
 * @param <E> Tipo de dato de los elementos a iterar.
 */
public class ElementIterator<E> implements Iterator<E> {
	protected PositionList<E> list; // la lista a iterar
	protected Position<E> cursor; // la posicion siguiente
	
	/**
	 * Crea un ElementIterator sobre la lista dada
	 * @param PositionList<E> L, la lista a iterar
	 */
	public ElementIterator (PositionList<E> L) {
		list=L;
		try {
			cursor = (list.isEmpty()) ? null : list.first();
		} catch (EmptyListException e) {
			e.getMessage();
		}
	}
	
	/**
	 * Retorna verdadero o falso si hay siguiente elemento
	 */
	public boolean hasNext() {
		return (cursor != null);	
	}
	
	/**
	 * Retorna el elemento siguiente
	 * @return E, el elemento retornado
	 */
	public E next() throws NoSuchElementException {
		if (cursor == null) 
			throw new NoSuchElementException ( "No hay siguiente elemento ");
		E toReturn = cursor.element();
		try {
			cursor = (cursor == list.last()) ? null : list.next(cursor);
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			e.getMessage();
		}
		
		return toReturn;
	}

}
