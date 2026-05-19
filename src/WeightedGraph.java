import java.util.*;

public class WeightedGraph<V> {

    private final boolean undirected;
    private final Map<V, Vertex<V>> vertices;

    public WeightedGraph() {
        this(true);
    }
    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
        this.vertices = new HashMap<>();
    }

    public void addVertex(V data) {
        vertices.putIfAbsent(data, new Vertex<>(data));
    }

    public void addEdge(V source, V dest, double weight) {

        addVertex(source);
        addVertex(dest);

        Vertex<V> sourceVertex = vertices.get(source);
        Vertex<V> destVertex = vertices.get(dest);

        sourceVertex.addAdjacentVertex(destVertex, weight);

        if (undirected) {
            destVertex.addAdjacentVertex(sourceVertex, weight);
        }
    }

    public boolean hasVertex(V data) {
        return vertices.containsKey(data);
    }
    public Vertex<V> getVertex(V data) {
        return vertices.get(data);
    }

    public List<Vertex<V>> adjacencyList(Vertex<V> vertex) {
        return new ArrayList<>(vertex.getAdjacentVertices().keySet());
    }

    public double getWeight(Vertex<V> source, Vertex<V> dest) {
        return source.getAdjacentVertices().get(dest);
    }

    public Collection<Vertex<V>> getAllVertices() {
        return vertices.values();
    }
}
