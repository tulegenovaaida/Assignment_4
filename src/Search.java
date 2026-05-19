import java.util.*;

public class Search<V> {

    protected Set<Vertex<V>> marked;
    protected Map<Vertex<V>, Vertex<V>> edgeTo;

    protected final Vertex<V> source;
    protected final WeightedGraph<V> graph;

    public Search(WeightedGraph<V> graph, V source) {
        this.graph = graph;
        this.source = graph.getVertex(source);

        marked = new HashSet<>();
        edgeTo = new HashMap<>();
    }

    public boolean hasPathTo(V v) {
        Vertex<V> vertex = graph.getVertex(v);

        return marked.contains(vertex);
    }

    public Iterable<V> pathTo(V v) {
        Vertex<V> destination = graph.getVertex(v);

        if (!hasPathTo(v)) {
            return null;
        }
        LinkedList<V> path = new LinkedList<>();

        for (Vertex<V> x = destination; x != source; x = edgeTo.get(x)) {
            path.push(x.getData());
        }
        path.push(source.getData());

        return path;
    }
}
