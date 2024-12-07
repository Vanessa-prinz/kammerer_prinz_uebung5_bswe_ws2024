package at.fh_burgenland.bswe.algo.algorithm;

import at.fh_burgenland.bswe.algo.graph.WeightedDirectedGraph;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DijkstraTest {

    @Test
    void dijkstra() {
        //Copy of ConnectedVertices
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_connectedVertices();
        assertEquals(Map.of("A", 0, "B", 3, "C", 4, "D", 5), Dijkstra.dijkstra(graph, "A"));
    }

    @Test
    void getShortestPath() {
        //Copy of ConnectedVertices
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_connectedVertices();
        assertEquals(List.of("A", "C", "D"), Dijkstra.getShortestPath(graph, Map.of("A", 0, "B", 3, "C", 4, "D", 5), "A", "D"));
    }

    @Test
    public void testDijkstra_singleVertex() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_singleVertex();
        assertEquals(Map.of("A", 0), Dijkstra.dijkstra(graph, "A"));
    }

    @Test
    public void testGetShortestPath_singleVertex() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_singleVertex();
        assertEquals(new ArrayList<>(), Dijkstra.getShortestPath(graph, new HashMap<>(), "A", "A"));
    }

    @Test
    public void testDijkstra_doubleVertex() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_doubleVertex();
        assertEquals(Map.of("A", 0, "B", 5), Dijkstra.dijkstra(graph, "A"));
    }

    @Test
    public void testGetShortestPath_doubleVertex() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_doubleVertex();
        assertEquals(List.of("A", "B"), Dijkstra.getShortestPath(graph, Map.of("A", 0, "B", 5), "A", "B"));
    }

    @Test
    public void testDijkstra_connectedVertices() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_connectedVertices();
        assertEquals(Map.of("A", 0, "B", 3, "C", 4, "D", 5), Dijkstra.dijkstra(graph, "A"));
    }

    @Test
    public void testGetShortestPath_connectedVertices() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_connectedVertices();
        assertEquals(List.of("A", "C", "D"), Dijkstra.getShortestPath(graph, Map.of("A", 0, "B", 3, "C", 4, "D", 5), "A", "D"));
    }

    @Test
    public void testDijkstra_weaklyConnected() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_weaklyConnectedVertices();
        assertEquals(Map.of("A", 0, "B", 3, "C", 5), Dijkstra.dijkstra(graph, "A"));
    }

    @Test
    public void testGetShortestPath_weaklyConnected() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_weaklyConnectedVertices();
        assertEquals(List.of("A", "B", "C"), Dijkstra.getShortestPath(graph, Map.of("A", 0, "B", 3, "C", 5), "A", "C"));
    }

    @Test
    public void testDijkstra_nonConnected() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_nonConnectedVertices();
        assertEquals(Map.of("A", 0, "B", 3, "C", Integer.MAX_VALUE), Dijkstra.dijkstra(graph, "A"));
    }

    @Test
    public void testGetShortestPath_nonConnected() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_nonConnectedVertices();
        assertEquals(new ArrayList<>(), Dijkstra.getShortestPath(graph, null, "A", "D"));
    }

    @Test
    public void testDijkstra_symmetricalGraph() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_symmetrical();
        assertEquals(Map.of("A", 0, "B", 3, "C", 4), Dijkstra.dijkstra(graph, "A"));
    }

    @Test
    public void testGetShortestPath_symmetricalGraph() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_symmetrical();
        assertEquals(List.of("A", "C"), Dijkstra.getShortestPath(graph, Map.of("A", 0, "B", 3, "C", 4), "A", "C"));
    }

    @Test
    public void testDijkstra_nullGraph() {
        assertEquals(new HashMap<>(), Dijkstra.dijkstra(null, "A"));
    }

    @Test
    public void testGetShortestPath_nullGraph() {
        assertEquals(new ArrayList<>(), Dijkstra.getShortestPath(null, new HashMap<>(), "A", "D"));
    }

    @Test
    public void testDijkstra_startNotIncludedInGraph() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_connectedVertices();
        assertEquals(new HashMap<>(), Dijkstra.dijkstra(graph, "F"));
    }

    @Test
    public void testGetShortestPath_startNotIncludedInGraph() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_connectedVertices();
        assertEquals(new ArrayList<>(), Dijkstra.getShortestPath(graph, Map.of("A", 0, "B", 3, "C", 4, "D", 5), "F", "C"));
    }

    @Test
    public void testGetShortestPath_endNotIncludedInGraph() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_connectedVertices();
        assertEquals(new ArrayList<>(), Dijkstra.getShortestPath(graph, Map.of("A", 0, "B", 3, "C", 4, "D", 5), "A", "F"));
    }

    @Test
    public void testGetShortestPath_startNotIncludedInDistances() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_connectedVertices();
        assertEquals(new ArrayList<>(), Dijkstra.getShortestPath(graph, Map.of("B", 3, "C", 4, "D", 5), "A", "D"));
    }

    @Test
    public void testGetShortestPath_endNotIncludedInDistances() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_connectedVertices();
        assertEquals(new ArrayList<>(), Dijkstra.getShortestPath(graph, Map.of("A", 0, "B", 3, "C", 4), "A", "D"));
    }

    @Test
    public void testGetShortestPath_distancesNotMatching_Failure() {
        WeightedDirectedGraph graph = DirectedGraphTestCases.createWeightedDirectedGraph_connectedVertices();
        assertEquals(new ArrayList<>(), Dijkstra.getShortestPath(graph, Map.of("A", 12, "B", 4, "C", 5, "D", 0), "A", "D"));
    }

//    @Test
//    public void testGetShortestPath_withPredecessors() {
//        WeightedDirectedGraph graph = createWeightedDirectedGraph_connectedVertices();
//        Map<String, Integer> distances = Dijkstra.dijkstra(graph, "A");
//
//        // Vorgänger-Map für den kürzesten Pfad
//        Map<String, String> predecessors = new HashMap<>();
//        predecessors.put("B", "A");
//        predecessors.put("C", "B");
//        predecessors.put("D", "C");
//
//        // Überprüfung des kürzesten Pfades von A nach D
//        List<String> path = Dijkstra.getShortestPath(graph, predecessors, "A", "D");
//        assertEquals(Arrays.asList("A", "B", "C", "D"), path);
//    }
}