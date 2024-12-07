package at.fh_burgenland.bswe.algo.algorithm;

import at.fh_burgenland.bswe.algo.graph.WeightedDirectedGraph;
import at.fh_burgenland.bswe.algo.graph.WeightedDirectedGraphImpl;

public class DirectedGraphTestCases {
    public static WeightedDirectedGraph createWeightedDirectedGraph_singleVertex() {
        WeightedDirectedGraph graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        return graph;
    }

    public static WeightedDirectedGraph createWeightedDirectedGraph_doubleVertex() {
        WeightedDirectedGraph graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addEdge("A", "B", 5);
        return graph;
    }

    public static WeightedDirectedGraph createWeightedDirectedGraph_connectedVertices() {
        WeightedDirectedGraph graph = new WeightedDirectedGraphImpl();
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

    public static WeightedDirectedGraph createWeightedDirectedGraph_symmetrical() {
        WeightedDirectedGraph graph = new WeightedDirectedGraphImpl();
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

    public static WeightedDirectedGraph createWeightedDirectedGraph_nonConnectedVertices() {
        WeightedDirectedGraph graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B", 3);
        return graph;
    }

    public static WeightedDirectedGraph createWeightedDirectedGraph_weaklyConnectedVertices() {
        WeightedDirectedGraph graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B", 3);
        graph.addEdge("B", "C", 2);

        return graph;
    }
}
