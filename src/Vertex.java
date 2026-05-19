import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<V> {

    private V data;
    private Map<Vertex<V>, Double> adjacentVertices;

    public Vertex(V data) {
        this.data = data;
        this.adjacentVertices = new HashMap<>();
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

    public void setAdjacentVertices(
            Map<Vertex<V>, Double> adjacentVertices) {

        this.adjacentVertices = adjacentVertices;
    }

    public void addAdjacentVertex(
            Vertex<V> destination,
            double weight) {

        adjacentVertices.put(destination, weight);
    }

    public boolean hasNeighbor(Vertex<V> vertex) {
        return adjacentVertices.containsKey(vertex);
    }

    public double getWeight(Vertex<V> vertex) {
        return adjacentVertices.get(vertex);
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Vertex<?> vertex = (Vertex<?>) o;

        return Objects.equals(data, vertex.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
