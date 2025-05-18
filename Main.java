package graphProject;

import java.util.Map;

public class Main {
    public static void main(String[] args) {

        WeightedGraph<String> graph = new WeightedGraph();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A","B",1);
        graph.addEdge("A","C",4);
        graph.addEdge("B","C",2);
        graph.addEdge("C","D",1);
        Search<String> bfs=new BreadthFirstSearch<>(graph,"A");
        System.out.println("BFS path from A to "+bfs.getPath("D"));

        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");

        A.addAdjacentVertex(B, 1);
        A.addAdjacentVertex(C, 4);
        B.addAdjacentVertex(C, 2);
        C.addAdjacentVertex(D, 1);

        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        Map<Vertex<String>, Double> distances = dijkstra.dijkstra(A);

        for (Map.Entry<Vertex<String>, Double> entry : distances.entrySet()) {
            System.out.println("Distance from A to " + entry.getKey() + " is " + entry.getValue());
        }
    }
}
