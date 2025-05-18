package graphProject;

import java.util.*;

public class BreadthFirstSearch<V> implements Search<V> {
    private Map<V, V> visited = new HashMap<>();
    private V start;

    public BreadthFirstSearch(WeightedGraph<V> graph, V start) {
        this.start = start;
        breadthFirstSearch(graph, start);
    }

    private void breadthFirstSearch(WeightedGraph<V> graph, V start) {
        Queue<V> queue = new LinkedList<>();
        queue.add(start);
        visited.put(start, null);
        while (!queue.isEmpty()) {
            V current = queue.remove();
            Vertex<V> vertex = graph.getVertex(current);
            for (Vertex<V> v : vertex.getAdjacentVertices().keySet()) {
                V neighbor = v.getData();
                if (!visited.containsKey(neighbor)) {
                    queue.add(neighbor);
                    visited.put(neighbor, current);
                }
            }
        }
    }

    @Override
    public List<V> getPath(V destination) {
        List<V> path = new ArrayList<>();
        for (V at = destination; at != null; at = visited.get(at)) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }
}
