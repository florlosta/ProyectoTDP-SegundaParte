package Proyecto1TDP;

public class LoggingTest {
	
	public static void main (String [] args) {
		Graph<Integer, Integer> grafo = new Graph<Integer, Integer>();
		
		System.out.println ("Agrego nodos que no existen en la estructura, chequeo metodo addNode()");
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(3);
		grafo.addNode(4);
		grafo.addNode(5);
		
		System.out.println ("Intento agregar un nodo que ya existe para probar funcionalidad del logging");
		grafo.addNode(3);
		grafo.addNode(4);
		
		System.out.println ("Creo arcos nuevos, en los que ambos nodos existan en la estructura");
		grafo.addEdge(1, 2);
		grafo.addEdge(3, 4);
		grafo.addEdge(1, 5);
		
		System.out.println ("Intento crear un arco nuevo, pero no existe el segundo nodo");
		
		grafo.addEdge(1, 6);
		grafo.addEdge(5, 8);
		
		System.out.println ("Misma prueba, solo que ahora no existe el primer nodo");
		grafo.addEdge(8, 1);
		grafo.addEdge(9, 3);
		
		System.out.println ("Ahora chequeamos que ocurre si ninguno de los nodos pertenece a la estructura");
		grafo.addEdge(10, 11);
		grafo.addEdge(6, 9);
		
		System.out.println ("¨Por ultimo, vemos que ocurre si el arco ya existe");
		grafo.addEdge(1, 2);
		grafo.addEdge(1, 5);
		
		System.out.println ("Ahora probamos los metodos de eliminar, empezamos con removeNode() cuando el nodo existe");
		grafo.removeNode(3);
		grafo.removeNode(4);
		
		System.out.println ("Podemos observar que el metodo funciona correctamente porque ocurre un error al querer eliminar un nodo que fue eliminado previamente");
		grafo.removeNode(3);
		grafo.removeNode(4);
		
		System.out.println ("Finalmente, vamos a probar el metodo removeEdge(), si ambos nodos y el arco existe ");
		grafo.removeEdge(1,2);
		grafo.removeEdge(3, 4);
		
		System.out.println ("Probamos que ocurre si no existe el primer nodo ");
		grafo.removeEdge(10, 1);
		grafo.removeEdge(9, 2);
		
		System.out.println ("Lo mismo con el segundo nodo ");
		grafo.removeEdge(1, 10);
		grafo.removeEdge(2, 9);
		
		System.out.println ("Ahora chequeamos si funciona cuando ninguno de los nodos pertence al grafo ");
		grafo.removeEdge(10, 11);
		grafo.removeEdge(6, 7);
		
		System.out.println ("La ultima prueba es intentar eliminar un arco previamente eliminado ");
		grafo.removeEdge(1, 2);
		grafo.removeEdge(3, 4);
		
		
		/**
		grafo1.addNode(1);
		grafo1.addNode(2);
		grafo1.addNode(3);
		grafo1.addNode(4);
		
		System.out.println("");
		grafo1.addEdge(1, 2);
		grafo1.addEdge(2, 3);
		grafo1.addEdge(3, 4);
		grafo1.addEdge(2, 3);
		grafo1.addEdge(3, 2);
		
		System.out.println ("Nueva prueba edge ");
		grafo1.addEdge(2, 3);
		grafo1.addEdge(7, 2);
		grafo1.addEdge(1, 8);
		grafo1.addEdge(8, 9);
		grafo1.addEdge(1, 4);
		
		System.out.println("Eliminar edge");
		
		grafo1.removeEdge(1, 2);
		grafo1.removeEdge(5, 6);
		grafo1.removeEdge(1, 2);
		grafo1.removeEdge(4, 3);
		grafo1.removeEdge(3, 4);
		
		System.out.println ("Agrego los arcos eliminados ");
		grafo1.addEdge(1, 2);
		grafo1.addEdge(3, 4);
		
		System.out.println("eliminar nodo ");
		grafo1.removeNode(2);
		grafo1.removeNode(6);
		grafo1.removeNode(2);
		**/
	}
}
