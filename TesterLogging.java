
public class TesterLogging {

	public static void main(String[] args) {
		Graph grafo = new Graph();
		
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(3);
		grafo.addNode(4);
		grafo.addNode(2);
		
		grafo.addEdge(3, 4);
		grafo.addEdge(2, 1);
		grafo.addEdge(1, 4);
		grafo.addEdge(4, 3);
		grafo.addEdge(1, 4);
		
		grafo.removeEdge(2, 1);
		grafo.removeEdge(2, 5);
		grafo.removeEdge(1, 1);
		grafo.removeEdge(6, 7);
		grafo.removeNode(1);
		grafo.removeEdge(1, 4);
		grafo.removeNode(7);
		
		

	}

}
