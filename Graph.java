import java.util.*;
import java.util.logging.*;

/**
 * Modela un grafo dirigido no pesado.
 * 
 * @author Mateo Denis
 *
 */
public class Graph {
	private Map<Integer, Integer> nodes;
	private Map<String, Edge> edges;
	private static Logger logger;

	/**
	 * Crea un grafo dirigido no pesado vacio.
	 */
	public Graph() {
		this.nodes = new HashMap<Integer, Integer>();
		this.edges = new HashMap<String, Edge>();
		
		if (logger == null) {

			logger = Logger.getLogger(Graph.class.getName());

			Handler hnd = new ConsoleHandler();
			hnd.setLevel(Level.WARNING);
			logger.addHandler(hnd);

			logger.setLevel(Level.WARNING);

			Logger rootLogger = logger.getParent();
			for (Handler h : rootLogger.getHandlers()) {
				h.setLevel(Level.OFF);
			}
		}
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
			logger.fine("Nodo " + node + " agregado al grafo exitosamente.");
		} else {
			logger.warning("No se pudo agregar, ya que el nodo " + node + " ya pertenece al grafo.");
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

		if (estaN1) {
			if (estaN2) {
				if (edges.get(identificador) == null) {
					edges.put(identificador, new Edge(node1, node2));
					logger.fine("Arco '" + node1 + "," + node2 + "' agregado al grafo exitosamente.");
				} else {
					logger.warning("No se pudo agregar, ya que el arco de origen " + node1 + " y  destino " + node2
							+ " ya pertenece al grafo.");
				}
			} else {
				logger.warning("No se pudo agregar el arco, ya que el nodo " + node2 + " no pertenece al grafo.");
			}
		} else {
			if (estaN2) {
				logger.warning("No se pudo agregar el arco, ya que el nodo " + node1 + " no pertenece al grafo.");
			} else {
				logger.warning("No se pudo agregar el arco, ya que ningun nodo pertenece al grafo.");
			}
		}

	}

	/**
	 * Remueve el nodo pasado por parametro del grafo, si es que este pertenece a la
	 * estructura.
	 * 
	 * @param node Nodo a remover.
	 */
	public void removeNode(int node) {
		Integer seRemovio = nodes.remove(node);
		
		if (seRemovio == null) {
			logger.warning("No se pudo remover, ya que el nodo " + node + " no pertenece al grafo.");
		} else {
			logger.fine("Nodo " + node + " removido del grafo exitosamente.");
		}
	}

	/**
	 * Remueve el arco pasado por parametro (representado por dos nodos) del grafo,
	 * si es que este pertenece a la estructura.
	 * 
	 * @param node1 Nodo origen del arco a remover.
	 * @param node2 Nodo destino del arco a remover.
	 */
	public void removeEdge(int node1, int node2) {
		Edge seRemovio = edges.remove(node1 + "," + node2);
		boolean estaN1 = nodes.containsKey(node1);
		boolean estaN2 = nodes.containsKey(node2);

		if (seRemovio == null) {
			if (estaN1) {
				if (estaN2) {
					logger.warning("No se pudo remover, ya que el arco de origen " + node1 + " y destino "
							+ node2 + " no pertenece al grafo.");
				} else {
					logger.warning("No se pudo remover el arco, ya que el nodo " + node2 + " no pertenece al grafo.");
				}
			} else {
				if (estaN2) {
					logger.warning("No se pudo remover el arco, ya que el nodo " + node1 + " no pertenece al grafo.");
				} else {
					logger.warning("No se pudo remover el arco, ya que ningun nodo pertenece al grafo.");
				}
			}
		} else {
			logger.fine("Arco '" + node1 + "," + node2 + "' removido del grafo exitosamente.");
		}
	}

}