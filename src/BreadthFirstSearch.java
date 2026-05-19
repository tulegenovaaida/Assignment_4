import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<V> extends Search<V> {

    public BreadthFirstSearch(UnweightedGraph<V> graph, V source) {
        super(graph, source);

        bfs(graph, this.source);
    }

    private void bfs(UnweightedGraph<V> graph, Vertex<V> current) {

        marked.add(current);

        Queue<Vertex<V>> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            Vertex<V> v = queue.remove();

            for (Vertex<V> vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, v);
                    queue.add(vertex);
                }
            }
        }
    }
}
