package graphProject;

public class Edge<V> {
    public Vertex<V> source;
    private Vertex<V> destination;
    private Double weight;
    public Edge(Vertex<V> source, Vertex<V> destination, Double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;

    }

    public Vertex<V> getSource() {
        return source;
    }

    public void setSource(Vertex<V> source) {
        this.source = source;
    }

    public Vertex<V> getDestination() {
        return destination;
    }

    public void setDestination(Vertex<V> destination) {
        this.destination = destination;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
