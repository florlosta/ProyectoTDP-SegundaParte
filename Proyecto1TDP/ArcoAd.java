package Proyecto1TDP;

import TDALista.Position;

/**
 * Clase arcoAd: Implementa los datos y operaciones aplicables sobre un arco adyacente.
 * @author Flor Loustaunau.
 *
 * @param <V> Tipo de dato de los elementos Vertice.
 * @param <E> Tipo de dato de los elementos Arco.
 */
public class ArcoAd<V, E> {
	private VerticeAd<Integer, Integer> sucesor, predecesor;
	private Position<ArcoAd<Integer, Integer>> posicionEnArcos, posPred, posSuces;

	/**
	 * Crea inicialmente un arco con una referencia a su vertice predecesor y sucesor.
	 */
	public ArcoAd(VerticeAd<Integer, Integer> predecesor, VerticeAd<Integer, Integer> sucesor) {
		this.predecesor = predecesor;
		this.sucesor = sucesor;
	}

	/**
	 * Crea incialmente un arco sin relacion con los vertices.
	 */
	public ArcoAd() {
		predecesor = null;
		sucesor = null;
	}

	/**
	 * Retorna la posicion del vertice predecesor del arco.
	 * @return VerticeAd<Integer, Integer> vertice predecesor de un determinado arco. 
	 */
	public VerticeAd<Integer, Integer> getPred() {
		return predecesor;
	}

	/**
	 * Retorna la posicion del vertice sucesor del arco.
	 * @return VerticeAd<Integer, Integer> vertice sucesor de un determinado arco. 
	 */
	public VerticeAd<Integer, Integer> getSuces() {
		return sucesor;
	}

	/**
	 * Retorna la posicion del arco en la lista de adyacencias. 
	 * @return Position<ArcoAd<Integer, Integer>>, posicion de un determinado arco en la lista de adyacencia.
	 */
	public Position<ArcoAd<Integer, Integer>> getPosicion() {
		return posicionEnArcos;
	}
	
	/**
	 * Inserta la posicion de un arco dado en la lista de adyacencia.
	 * @param p, Position<ArcoAd<Integer, Integer>> posicion de un determinado arco.
	 */
	public void setPosicionEnAdyacentes(Position<ArcoAd<Integer, Integer>> p) {
		posicionEnArcos = p;
	}

	/**
	 * Inserta la posicion de un vertice predecesor a un arco. 
	 * @param v, VerticeAd<Integer, Integer> vertice predecesor del arco. 
	 */
	public void setPred(VerticeAd<Integer, Integer> v) {
		predecesor = v;
	}

	/**
	 * Inserta la posicion de un vertice sucesor a un arco. 
	 * @param v, VerticeAd<Integer, Integer> vertice sucesor del arco. 
	 */
	public void setSuces(VerticeAd<Integer, Integer> v) {
		sucesor = v;
	}

	/**
	 * Retorna la posicion del arco predecesor en la lista de adyacencia.
	 * @return Position<ArcoAd<Integer, Integer>>, posicion del arco predecesor en la lista de adyacencia.
	 */
	public Position<ArcoAd<Integer, Integer>> getPosPred() {
		return posPred;
	}

	/**
	 * Retorna la posicion del arco sucesor en la lista de adyacencia.
	 * @return Position<ArcoAd<Integer, Integer>>, posicion del arco sucesor en la lista de adyacencia.
	 */
	public Position<ArcoAd<Integer, Integer>> getPosSuces() {
		return posSuces;
	}

	/**
	 * Inserta la posicion del arco predecesor en la lista de adyacencia. 
	 * @param p, Position<ArcoAd<Integer, Integer>>, posicion del arco predecesor en la lista de adyacencia.
	 */
	public void setPosPred(Position<ArcoAd<Integer, Integer>> p) {
		posPred = p;
	}

	/**
	 * Inserta la posicion del arco sucesor en la lista de adyacencia. 
	 * @param p, Position<ArcoAd<Integer, Integer>>, posicion del arco sucesor en la lista de adyacencia.
	 */
	public void setPosSuces(Position<ArcoAd<Integer, Integer>> s) {
		posSuces = s;
	}
}