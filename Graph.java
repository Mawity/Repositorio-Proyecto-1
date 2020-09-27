import java.util.*;
/**
 * Modela un grafo dirigido no pesado.
 * 
 * @author Esteban Quito
 *
 */
public class Graph {
	private Map<Integer, Integer> nodes;
	private Map<String, Edge> edges;

	/**
	 * Crea un grafo dirigido no pesado vacio.
	 */
	public Graph() {
		this.nodes = new HashMap<Integer, Integer>();
		this.edges = new HashMap<String, Edge>();
	}

	/**
	 * Agrega el nodo pasado por parametro al grafo, si aún no pertenecía a la
	 * estructura.
	 * 
	 * @param node Nodo a insertar.
	 */
	public void addNode(int node) {
		if (nodes.get(node) == null) {
			nodes.put(node, node);
		}
	}

	/**
	 * Agrega el arco pasado por parametro (representado por dos nodos) al grafo, si
	 * aún no pertenecía a la estructura.
	 * 
	 * @param node1 Nodo origen del arco a insertar.
	 * 
	 * @param node2 Nodo destino del arco a insertar.
	 */
	public void addEdge(int node1, int node2) {
		String identificador = node1 + "," + node2;
		boolean estaN1 = nodes.containsKey(node1);
		boolean estaN2 = nodes.containsKey(node2);

		if (edges.get(identificador) == null && estaN1 && estaN2) {
			edges.put(identificador, new Edge(node1, node2));
		}
	}

	/**
	 * Remueve el nodo pasado por parametro del grafo, si es que este pertenece a la
	 * estructura.
	 * 
	 * @param node Nodo a remover.
	 */
	public void removeNode(int node) {
			nodes.remove(node);
	}

	/**
	 * Remueve el arco pasado por parametro (representado por dos nodos) del grafo,
	 * si es que este pertenece a la estructura.
	 * 
	 * @param node1 Nodo origen del arco a remover.
	 * @param node2 Nodo destino del arco a remover.
	 */
	public void removeEdge(int node1, int node2) {
		edges.remove(node1 + "," + node2);
	}

}
