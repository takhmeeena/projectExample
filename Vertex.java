package graphProject;

import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices = new HashMap<Vertex<V>, Double>();

    public Vertex(V data) {
        this.data = data;
    }
    public void addAdjacentVertex(Vertex<V> destination,double weight ) {
        adjacentVertices.put(destination, weight);
    }

    public V getData() {
        return data;
    }

    public void setData(V data) {
        this.data = data;
    }

    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    public void setAdjacentVertices(Map<Vertex<V>, Double> adjacentVertices) {
        this.adjacentVertices = adjacentVertices;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "data=" + data +
                ", adjacentVertices=" + adjacentVertices +
                '}';
    }
}
