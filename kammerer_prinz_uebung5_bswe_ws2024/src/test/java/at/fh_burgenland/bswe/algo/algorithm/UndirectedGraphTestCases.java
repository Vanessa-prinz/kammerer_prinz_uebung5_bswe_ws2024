package at.fh_burgenland.bswe.algo.algorithm;

import at.fh_burgenland.bswe.algo.graph.WeightedUndirectedGraph;
import at.fh_burgenland.bswe.algo.graph.WeightedUndirectedGraphImpl;

/**
 * This helper class creates different types of test graphs for the test class of the prim algorithm.
 */
public class UndirectedGraphTestCases {

    /**
     * This method creates a weighted undirected graph with a single vertex.
     * @return the graph with one vertex
     */
    public static WeightedUndirectedGraph createWeightedUndirectedGraph_singleVertex() {
        WeightedUndirectedGraph graph = new WeightedUndirectedGraphImpl();
        graph.addVertex("A");
        return graph;
    }

    /**
     * This method creates a weighted undirected graph with two vertex.
     * @return the graph with two vertex
     */
    public static WeightedUndirectedGraph createWeightedUndirectedGraph_doubleVertex() {
        WeightedUndirectedGraph graph = new WeightedUndirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 5);
        return graph;
    }

    /**
     * This method creates a weighted undirected graph where all vertices are connected.
     * @return the graph with vertices and edges as described
     */
    public static WeightedUndirectedGraph createWeightedUndirectedGraph_connectedVertices() {
        WeightedUndirectedGraph graph = new WeightedUndirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");

        graph.addEdge("A", "B", 3);
        graph.addEdge("A", "C", 4);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "A", 5);

        return graph;
    }

    /**
     * This method creates a weighted undirected graph where both directions are symmetrical.
     * @return the symmetrical graph with vertices and edges as described
     */
    public static WeightedUndirectedGraph createWeightedUndirectedGraph_symmetrical() {
        WeightedUndirectedGraph graph = new WeightedUndirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "A", 3);
        graph.addEdge("B", "C", 2);
        graph.addEdge("C", "B", 2);
        graph.addEdge("A", "C", 4);
        graph.addEdge("C", "A", 4);

        return graph;
    }

    /**
     * This method creates a weighted undirected graph where one vertex stands alone, making this graph disconnected.
     * @return the non-connected graph
     */
    public static WeightedUndirectedGraph createWeightedUndirectedGraph_nonConnectedVertices() {
        WeightedUndirectedGraph graph = new WeightedUndirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B", 3);

        return graph;
    }

    /**
     * This method creates a weakly connected weighted undirected graph.
     * @return the weakly connected graph
     */
    public static WeightedUndirectedGraph createWeightedUndirectedGraph_weaklyConnectedVertices() {
        WeightedUndirectedGraph graph = new WeightedUndirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "C", 2);

        return graph;
    }
}