public class DepthFirstSearch<V> extends Search<V> {

    public DepthFirstSearch(UnweightedGraph<V> graph, V source) {
        super(graph, source);

        dfs(graph, this.source);
    }

    private void dfs(UnweightedGraph<V> graph, Vertex<V> current) {
        marked.add(current);

        for (Vertex<V> v : graph.adjacencyList(current)) {

            if (!marked.contains(v)) {
                edgeTo.put(v, current);
                dfs(graph, v);
            }
        }
    }
}
