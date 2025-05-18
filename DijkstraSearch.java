package graphProject;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class DijkstraSearch<V> {
    public Map<Vertex<V>, Double> dijkstra(Vertex<V> start) {


        Map<Vertex<V>, Double> distances = new HashMap<>();
        PriorityQueue<Vertex<V>> queue = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        distances.put(start, 0.0);
        queue.add(start);
        while(!queue.isEmpty()) {
            Vertex<V> current = queue.poll();
            for(Map.Entry<Vertex<V>, Double> neighbor : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighborVertex = neighbor.getKey();
                double weight= neighbor.getValue();
                double currentDistanceToNeighbor = distances.getOrDefault(neighborVertex, Double.POSITIVE_INFINITY);
                double distanceFromCurrent = distances.get(current) + weight;
                if (distanceFromCurrent < currentDistanceToNeighbor) {
                    distances.put(neighborVertex, distanceFromCurrent);
                    queue.add(neighborVertex);
                }
            }
        }
        return distances;
    }
}
