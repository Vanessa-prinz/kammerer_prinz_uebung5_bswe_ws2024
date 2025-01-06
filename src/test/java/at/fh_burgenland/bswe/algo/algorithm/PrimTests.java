package at.fh_burgenland.bswe.algo.algorithm;

import at.fh_burgenland.bswe.algo.graph.WeightedUndirectedGraph;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This test class contains test methods for the Prim algorithm for different weighted undirected graphs.
 */
class PrimTests {

    /**
     * This test method shows if the prim algorithm finds the correct MST in a connected graph.
     */
    @Test
    void prim_Success() {
        WeightedUndirectedGraph graph = UndirectedGraphTestCases.createWeightedUndirectedGraph_connectedVertices();
        Assertions.assertEquals(List.of("A-B", "B-C", "C-D"), Prim.prim(graph));
    }

    /**
     * This test method shows if the prim algorithm finds the correct MST in a connected graph
     * by comparing it with an incorrect return list.
     */
    @Test
    void prim_Failure() {
        WeightedUndirectedGraph graph = UndirectedGraphTestCases.createWeightedUndirectedGraph_connectedVertices();
        Assertions.assertNotEquals(List.of("A-B", "B-C", "C-D", "D-A"), Prim.prim(graph));
    }

    /**
     * This test method shows if the prim algorithm handles a graph with a single vertex correct.
     * It should return an empty list, since no edges exist.
     */
    @Test
    void testPrim_singleVertex() {
        WeightedUndirectedGraph graph = UndirectedGraphTestCases.createWeightedUndirectedGraph_singleVertex();
        Assertions.assertEquals(List.of(), Prim.prim(graph));
    }

    /**
     * This test method shows if the prim algorithm handles a graph with two vertices and a single edge correct.
     * The expected MST is the single edge.
     */
    @Test
    void testPrim_doubleVertex() {
        WeightedUndirectedGraph graph = UndirectedGraphTestCases.createWeightedUndirectedGraph_doubleVertex();
        Assertions.assertEquals(List.of("A-B"), Prim.prim(graph));
    }

    /**
     * This test method shows if the prim algorithm handles a connected graph with more vertices correct.
     * It should return the expected MST.
     */
    @Test
    void testPrim_connectedVertices() {
        WeightedUndirectedGraph graph = UndirectedGraphTestCases.createWeightedUndirectedGraph_connectedVertices();
        Assertions.assertEquals(List.of("A-B", "B-C", "C-D"), Prim.prim(graph));
    }

    /**
     * This test method shows if the prim algorithm handles a weakly connected graph correctly.
     * It should return the expected MST.
     */
    @Test
    public void testPrim_weaklyConnected() {
        WeightedUndirectedGraph graph = UndirectedGraphTestCases.createWeightedUndirectedGraph_weaklyConnectedVertices();
        Assertions.assertEquals(List.of("A-B", "B-C"), Prim.prim(graph));
    }

    /**
     * This test method shows if the prim algorithm handles a non-connected graph correctly.
     * The prim algorithm requires a connected graph, an IllegalStateException should be thrown.
     */
    @Test
    void testPrim_nonConnected() {
        WeightedUndirectedGraph graph = UndirectedGraphTestCases.createWeightedUndirectedGraph_nonConnectedVertices();
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class, () -> Prim.prim(graph));
        Assertions.assertEquals("Graph is not connected, MST cannot be formed.", exception.getMessage());
    }

    /**
     * This test method shows if the prim algorithm handles a symmetrical graph correctly.
     * The edges in this graph have the same weight in both directions.
     * It should return the expected MST.
     */
    @Test
    void testPrim_symmetricalGraph() {
        WeightedUndirectedGraph graph = UndirectedGraphTestCases.createWeightedUndirectedGraph_symmetrical();
        Assertions.assertEquals(List.of("A-B", "B-C"), Prim.prim(graph));
    }

    /**
     * This test method shows if the prim algorithm handles a null graph correctly.
     * if the input graph is null, it should return an empty list.
     */
    @Test
    public void testPrim_nullGraph() {
        Assertions.assertEquals(new ArrayList<>(), Prim.prim(null));
    }
}