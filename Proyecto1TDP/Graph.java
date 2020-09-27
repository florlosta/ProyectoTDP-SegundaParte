package Proyecto1TDP;

import TDALista.BoundaryViolationException;
import TDALista.EmptyListException;
import TDALista.InvalidPositionException;
import TDALista.Lista_doble_enlazada;
import TDALista.Position;
import TDALista.PositionList;

import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Implementacion grafo dirigido no pesado con listas de adyacencias
 * @author Flor Loustaunau
 *
 * @param <V> parametro asociado a los nodos.
 * @param <E> parametro asociado a los arcos. 
 */
public class Graph<V, E> {

	private static Logger Logger;
	private PositionList<VerticeAd<Integer, Integer>> nodos;
	private PositionList<ArcoAd<Integer, Integer>> arcos;

	/**
	 * Crea inicialmente un grafo con dos listas de adyacencias, ademas incializa el proceso de Logging. 
	 */
	public Graph() {

		if (Logger == null) {
			Logger = java.util.logging.Logger.getLogger(Graph.class.getName());
			Handler handler = new ConsoleHandler();
			handler.setLevel(Level.FINE);

			Logger.addHandler(handler);
			Logger.setLevel(Level.FINE);

			Logger rootLogger = Logger.getParent();
			for (Handler h : rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
		}

		nodos = new Lista_doble_enlazada<VerticeAd<Integer, Integer>>();
		arcos = new Lista_doble_enlazada<ArcoAd<Integer, Integer>>();
	}

	/**
	 * Agrega el nodo "node" al grafo, si aun no pertenecia a la estructura.
	 * @param node, valor del nodo a ser ingresado.
	 */
	public void addNode(int node) {
		boolean esta = estaNodo(node);

		try {

			if (!esta) {
				VerticeAd<Integer, Integer> nuevo = new VerticeAd<Integer, Integer>(node);
				nodos.addLast(nuevo);
				nuevo.setPosicionEnNodo(nodos.last());
				Logger.info("El nodo " + node + " fue añadido con exito ");
			} else
				Logger.warning("El nodo " + node + " ya estaba en el grafo. Por favor, reintente. ");

		} catch (EmptyListException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Agrega un arco entre el nodo "node1" y el nodo "node2", si aun no existia el arco y ambos parametros son
	 * nodos pertenecientes a la estructura.
	 * @param node1, valor del nodo origen del arco.
	 * @param node2, valor del nodo destino del arco.
	 */
	public void addEdge(int node1, int node2) {
		boolean estaNodo1 = estaNodo(node1);
		boolean estaNodo2 = estaNodo(node2);

		if (estaNodo1 && estaNodo2) {
			VerticeAd<Integer, Integer> nodo1 = new VerticeAd<Integer, Integer>(node1);
			VerticeAd<Integer, Integer> nodo2 = new VerticeAd<Integer, Integer>(node2);

			boolean estaArco = estaArco(node1, node2);

			if (!estaArco) {
				try {
					ArcoAd<Integer, Integer> arco = new ArcoAd<Integer, Integer>(nodo1, nodo2);
					nodo1.getAdyacentes().addLast(arco);
					arco.setPosicionEnAdyacentes(nodo1.getAdyacentes().last());
					nodo2.getAdyacentes().addLast(arco);
					arco.setPosicionEnAdyacentes(nodo2.getAdyacentes().last());
					arcos.addLast(arco);
					arco.setPosicionEnAdyacentes(arcos.last());
					Logger.info("El arco (" + node1 + "," + node2 + ") ha sido añadido correctamente al grafo. ");
				} catch (TDALista.EmptyListException ex) {
					ex.getMessage();
				}
			} else {
				Logger.warning("El arco (" +node1 +","+ node2 + ") entre ambos nodos ya existe en el grafo. Por favor, reintente. ");
			}
		} else {
			if (!estaNodo1 && !estaNodo2) {
				Logger.warning("Los nodos "+ node1 +" y "+node2 + " no pertenecen al grafo. Por favor, reintente. ");
			} else {
				if (!estaNodo2) {
					Logger.warning("El nodo " + node2 + " no pertenece al grafo. Por favor, reintente.");
				} else
					Logger.warning("El nodo " + node1 + " no pertenece al grafo. Por favor, reintente.");
			}
		}
	}

	/**
	 * Remueve el nodo "node" del grafo, si el parametro es un nodo de la estructura.
	 * @param node, valor del nodo a ser removido.
	 */
	public void removeNode(int node) {
		boolean esta = estaNodo(node);
		try {
			if (esta) {
				VerticeAd<Integer, Integer> nodo = buscarNodo(node);

				for (ArcoAd<Integer, Integer> arco : nodo.getAdyacentes()) {
					arcos.remove(arco.getPosicion());
					arco.getPred().getAdyacentes().remove(arco.getPosPred());
					arco.getSuces().getAdyacentes().remove(arco.getPosSuces());
					arco.setPred(null);
					arco.setSuces(null);
				}
				

				Position<VerticeAd<Integer, Integer>> pos = ((VerticeAd<Integer, Integer>)nodo).getPosicion();
				nodos.remove(pos).element();
				
			
				Logger.info("El nodo " + node + " fue removido con exito ");
			} else
				Logger.warning("El nodo " + node + " no pertenece al grafo actual. Por favor, reintente. ");
		} catch (InvalidPositionException e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Remueve el arco entre el nodo "node1" y el nodo "node2", si el arco formado por los parametros pertenecen a la estructura.
	 * @param node1, nodo origen del arco a ser eliminado.
	 * @param node2, nodo destino del arco a ser eliminado.
	 */
	public void removeEdge(int node1, int node2) {
		boolean estaNodo1 = estaNodo(node1);
		boolean estaNodo2 = estaNodo(node2);
		ArcoAd<Integer, Integer> arco = buscarArco(node1, node2);

		if (estaNodo1 && estaNodo2) {

			if (arco != null) {
				try {
					arcos.remove(arco.getPosicion());
					arco.getPred();
					arco.getSuces();

					arco.setPred(null);
					arco.setSuces(null);

					Logger.info("El arco (" + node1 + "," + node2 + ") fue removido con exito. ");

				} catch (InvalidPositionException e1) {
					System.out.println(e1.getMessage());
				}
			} else
				Logger.info("El arco (" + node1 + "," + node2 + ") no pertenece al grafo. Reintente, por favor. ");
			
		} else {
			if (!estaNodo1 && !estaNodo2) {
				Logger.warning(
						"Los nodos " + node1 + " y " + node2 + " no pertenecen al grafo. Por favor, reintente. ");
			} else {
				if (!estaNodo2) {
					Logger.warning("El nodo " + node2 + " no pertenece al grafo. Por favor, reintente.");
				} else
					Logger.warning("El nodo " + node1 + " no pertenece al grafo. Por favor, reintente.");
			}
		}

	}

	/**
	 * Metodo privado que busca y retorna el vertice asociado a un rotulo de un nodo.
	 * @param node, valor del rotulo del nodo a ser buscado.
	 * @return VerticeAd<Integer, Integer>, vertice que se corresponde con un rotulo pasado por parametro. 
	 */
	private VerticeAd<Integer, Integer> buscarNodo(int node) {
		VerticeAd<Integer, Integer> vertice = null;
		boolean esta = false;
		Position<VerticeAd<Integer, Integer>> indice = null;

		try {
			if (!nodos.isEmpty()) {
				indice = nodos.first();
			}

			while (!esta && indice != null) {
				if (indice.element().element() == node) {
					vertice = indice.element();
				}
				indice = (indice == nodos.last() ? null : nodos.next(indice));
			}
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			e.printStackTrace();
		}
		return vertice;
	}

	/**
	 * Metodo privado que busca y retorna el arco asociado a dos rotulos de nodos.
	 * @param node1, valor del rotulo del nodo origen.
	 * @param node2, valor del rotulo del nodo destino. 
	 * @return ArcoAd<Integer, Integer>, arco dirigido que se corresponde con los dos nodos pasados por parametro.
	 */
	private ArcoAd<Integer, Integer> buscarArco(int node1, int node2) {
		ArcoAd<Integer, Integer> arco = null;
		boolean esta = false;
		Position<ArcoAd<Integer, Integer>> indice = null;
		
		try {
		if (!arcos.isEmpty()) {
			indice = arcos.first();
		}
		
		while (!esta && indice != null) {
			if (indice.element().getPred().element() == node1 && indice.element().getSuces().element() == node2) {
				arco = indice.element().getPosicion().element();
			}
			indice = (indice == arcos.last() ? null : arcos.next(indice));
		}
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			e.printStackTrace();
		}
		
		return arco;
	}

	/**
	 * Metodo privado que busca si un nodo se encuentra en la estructura por medio de su rotulo.
	 * @param nodo, valor del rotulo del nodo a buscar.
	 * @return boolean, verdadero si el nodo esta, falso en caso contrario.
	 */
	private boolean estaNodo(int nodo) {
		Position<VerticeAd<Integer, Integer>> indice = null;
		boolean esta = false;

		try {
			if (!nodos.isEmpty()) {
				indice = nodos.first();
			}

			while (!esta && indice != null) {
				if (indice.element().element() == nodo) {
					esta = true;
				}

				indice = (indice == nodos.last() ? null : nodos.next(indice));
			}
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			e.printStackTrace();
		}

		return esta;
	}
	
	/**
	 * Metodo privado que busca si un arco se encuentra en la estructura por medio de los rotulos de los nodos de origen y destino.
	 * @param node1, valor del rotulo del nodo origen.
	 * @param node2, valor del rotulo del nodo destino.
	 * @return boolean, verdadero si el arco esta, falso en caso contrario. 
	 */
	private boolean estaArco(int node1, int node2) {
		boolean esta = false;
		Position<ArcoAd<Integer, Integer>> indice = null;

		try {
			if (!arcos.isEmpty()) {
				indice = arcos.first();
			}

			while (!esta && indice != null) {
				if (indice.element().getPred().element() == node1 && indice.element().getSuces().element() == node2) {
					esta = true;
				}

				indice = (indice == arcos.last() ? null : arcos.next(indice));
			}
		} catch (EmptyListException | InvalidPositionException | BoundaryViolationException e) {
			e.printStackTrace();
		}

		return esta;
	}

}
	