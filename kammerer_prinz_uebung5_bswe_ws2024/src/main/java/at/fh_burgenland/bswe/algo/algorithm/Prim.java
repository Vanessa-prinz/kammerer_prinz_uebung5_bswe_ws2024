package at.fh_burgenland.bswe.algo.algorithm;

import at.fh_burgenland.bswe.algo.graph.Edge;
import at.fh_burgenland.bswe.algo.graph.WeightedUndirectedGraph;

import java.util.*;

/**
 * This class provides methods to calculate the Minimum Spanning Tree (MST) of a weighted undirected graph using the Prim algorithm.
 */
public class Prim {

    /**
     * Calculates the minimum spanning tree of a graph using Prim's algorithm.
     * format: ["A-B", "B-C", ...]
     *
     * @param graph The weighted undirected graph to calculate the MST on. Must be connected.
     * @return A list of edges representing the minimum spanning tree (MST)
     *
     */
    public static List<String> prim(WeightedUndirectedGraph graph) {
        if (graph == null || graph.getVertices().isEmpty()) {
            return Collections.emptyList();
        }

        Set<String> visitedVertices = new HashSet<>();
        PriorityQueue<Edge> edgeQueue = new PriorityQueue<>(Comparator.comparingInt(Edge::weight));
        List<String> mstEdges = new ArrayList<>();

        String start = graph.getVertices().iterator().next();
        visitedVertices.add(start); //als besucht markiert

        for (String neighbor : graph.getNeighbors(start)) {
            edgeQueue.add(new Edge(start, neighbor, graph.getWeight(start, neighbor)));
        }

        while (!edgeQueue.isEmpty() && visitedVertices.size() < graph.getVertices().size()) {
            Edge smallestEdge = edgeQueue.poll(); //aus queue entfernen und in smallestEdge speichern

            String from = smallestEdge.from();
            String to = smallestEdge.to();

            if (visitedVertices.contains(from) && visitedVertices.contains(to)) { //Kanten deren Knoten from und to schon besucht wurden überspringen
                continue;
            }

            mstEdges.add(from + "-" + to);

            //String newVertex = visitedVertices.contains(from) ? to : from;
            String newVertex;
            if (visitedVertices.contains(from)) {
                newVertex = to;
            } else {
                newVertex = from;
            }
            visitedVertices.add(newVertex);

            for (String neighbor : graph.getNeighbors(newVertex)) {
                if (!visitedVertices.contains(neighbor)) {
                    edgeQueue.add(new Edge(newVertex, neighbor, graph.getWeight(newVertex, neighbor)));
                }
            }
        }

        if (visitedVertices.size() < graph.getVertices().size()) { //prüft, ob alle Knoten besucht
            throw new IllegalStateException("Graph is not connected, MST cannot be formed.");
        }

        return mstEdges;
    }
}