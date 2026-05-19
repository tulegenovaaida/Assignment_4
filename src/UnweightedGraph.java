public class UnweightedGraph<V> extends WeightedGraph<V> {

    public UnweightedGraph() {
        super(true);
    }
    public UnweightedGraph(boolean undirected) {
        super(undirected);
    }

    public void addEdge(V source, V dest) {
        super.addEdge(source, dest, 1.0);
    }
}
