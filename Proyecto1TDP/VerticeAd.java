package Proyecto1TDP;

import TDALista.Lista_doble_enlazada;
import TDALista.Position;
import TDALista.PositionList;

/**
 * Clase verticeAd: Implementa los datos y operaciones aplicables sobre un vertice adyacente.
 * @author Flor Loustaunau.
 *
 * @param <V> Tipo de dato de los elementos Vertice.
 * @param <E> Tipo de dato de los elementos Arco.
 */
public class VerticeAd<V, E> {

	private int rotulo;
	private PositionList<ArcoAd<Integer, Integer>> adyacentes;
	private Position<VerticeAd<Integer, Integer>> posicionEnNodos;


	/**
	 * Crea inicialmente un vertice con el valor de su rotulo.
	 */
	public VerticeAd(int rotulo) {
		this.rotulo = rotulo;
		adyacentes = new Lista_doble_enlazada<ArcoAd<Integer, Integer>>();
	}

	/**
	 * Retorna el valor del elemento del rotulo.
	 * @return int, valor del elemento del rotulo del vertice.
	 */
	public int element() {
		return rotulo;
	}

	/**
	 * Retorna una lista de los arcos adyacentes a un determinado nodo. 
	 * @return PositionList<ArcoAd<Integer, Integer>>, lista de arcos adyacentes.
	 */
	public PositionList<ArcoAd<Integer, Integer>> getAdyacentes() {
		return adyacentes;
	}

	/**
	 * Retorna la posicion del vertice en la lista de adyacencia. 
	 * @return Position<VerticeAd<Integer, Integer>>, posicion del vertice en la lista de adyacencia.
	 */
	public Position<VerticeAd<Integer, Integer>> getPosicion() {
		return posicionEnNodos;
	}

	/**
	 * Setea el valor del rotulo del vertice.
	 * @param elem, int que representa el valor del rotulo del vertice.
	 */
	public void setElement(int elem) {
		rotulo = elem;
	}

	/**
	 * Setea la posicion de un vertice en la lista de adyacencia. 
	 * @param position, Position<VerticeAd<Integer, Integer>> posicion del vertice a ser seteado en la lista de adyacencia.
	 */
	public void setPosicionEnNodo(Position<VerticeAd<Integer, Integer>> position) {
		posicionEnNodos = position;
	}


}
