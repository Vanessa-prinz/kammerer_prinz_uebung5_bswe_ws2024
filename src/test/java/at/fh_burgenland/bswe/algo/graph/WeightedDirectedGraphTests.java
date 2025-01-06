package at.fh_burgenland.bswe.algo.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test class contains various test methods for a weighted directed graph.
 */
class WeightedDirectedGraphTests {

    WeightedDirectedGraph graph;

    /**
     * This method sets up the graph before each test.
     * It initializes the graph with vertices and edges.
     */
    @BeforeEach
    void setUp() {
        graph = new WeightedDirectedGraphImpl();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");

        graph.addEdge("A", "B", 5);
        graph.addEdge("B", "C", 10);
    }

    /**
     * This test method verifies that a new vertex can be added to the graph.
     */
    @Test
    void addVertex() {
        graph.addVertex("D");
        Assertions.assertTrue(graph.hasVertex("A"));
    }

    /**
     * This test method verifies that existing and non-existing vertices are correctly identified.
     */
    @Test
    void hasVertex() {
        Assertions.assertTrue(graph.hasVertex("A"));
        Assertions.assertFalse(graph.hasVertex("D"));
    }

    /**
     * This test method verifies that a vertex can be removed from the graph.
     */
    @Test
    void removeVertex() {
        graph.removeVertex("A");
        Assertions.assertFalse(graph.hasVertex("A"));
    }

    /**
     * This test method verifies that an edge can be added between two vertices and the edge is directed.
     */
    @Test
    void addEdge() {
        Assertions.assertTrue(graph.hasEdge("A", "B"));
        Assertions.assertFalse(graph.hasEdge("B", "A"));
        Assertions.assertEquals(5, graph.getWeight("A", "B"));
    }

    /**
     * This test method verifies that existing and non-existing edges are correctly identified and directed.
     */
    @Test
    void hasEdge() {
        Assertions.assertTrue(graph.hasEdge("A", "B"));
        Assertions.assertFalse(graph.hasEdge("B", "A"));
        Assertions.assertFalse(graph.hasEdge("A", "C"));
    }

    /**
     * This test method verifies that an edge can be removed between two vertices.
     */
    @Test
    void removeEdge() {
        graph.removeEdge("A", "B");
        Assertions.assertFalse(graph.hasEdge("A", "B"));
        Assertions.assertFalse(graph.hasEdge("B", "A"));
    }

    /**
     * This test method verifies that the neighbors of a given vertex are returned correctly.
     */
    @Test
    void getNeighbors() {
        Assertions.assertTrue(graph.getNeighbors("A").contains("B"));
        Assertions.assertTrue(graph.getNeighbors("B").contains("C"));
    }

    /**
     * This test method verifies that the weight of a given edge is returned correctly.
     */
    @Test
    void getWeight() {
        Assertions.assertEquals(5, graph.getWeight("A", "B"));
    }

    /**
     * This test method verifies that the vertices are returned correctly.
     */
    @Test
    void getVertices() {
        Assertions.assertTrue(graph.getVertices().contains("A"));
        Assertions.assertTrue(graph.getVertices().contains("B"));
        Assertions.assertTrue(graph.getVertices().contains("C"));
    }

    /**
     * This test method verifies that the number of vertices in the graph is returned correctly.
     */
    @Test
    void getNumberOfVertices() {
        Assertions.assertEquals(3, graph.getNumberOfVertices());
    }

    /**
     * This test method verifies that the number of edges in the graph is returned correctly.
     */
    @Test
    void getNumberOfEdges() {
        Assertions.assertEquals(2, graph.getNumberOfEdges());
    }
}