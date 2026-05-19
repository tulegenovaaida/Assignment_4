import java.util.*;
public class DijkstraSearch<V> extends Search<V> {

    private final Set<Vertex<V>> unsettledNodes;
    private final Map<Vertex<V>, Double> distances;
    private final WeightedGraph<V> graph;

    public DijkstraSearch(WeightedGraph<V> graph, V source) {
        super(graph, source);
        this.graph = graph;

        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();

        dijkstra();
    }

    private void dijkstra() {
        distances.put(source, 0.0);
        unsettledNodes.add(source);

        while (!unsettledNodes.isEmpty()) {
            Vertex<V> current = getVertexWithMinimumWeight(unsettledNodes);
          
            unsettledNodes.remove(current);
            marked.add(current);

            for (Vertex<V> neighbor : graph.adjacencyList(current)) {
                double newDistance = getShortestDistance(current) + graph.getWeight(current, neighbor);

                if (getShortestDistance(neighbor) > newDistance) {
                    distances.put(neighbor, newDistance);
                    edgeTo.put(neighbor, current);
                    unsettledNodes.add(neighbor);
                }
            }
        }
    }
    private Vertex<V> getVertexWithMinimumWeight(
            Set<Vertex<V>> vertices) {
        Vertex<V> minimum = null;

        for (Vertex<V> vertex : vertices) {

            if (minimum == null) {
                minimum = vertex;
                continue;
            }
            if (getShortestDistance(vertex) < getShortestDistance(minimum)) {
                minimum = vertex;
            }
        }

        return minimum;
    }

    private double getShortestDistance(Vertex<V> destination) {

        Double distance = distances.get(destination);

        return distance == null ? Double.MAX_VALUE : distance;
    }
}
