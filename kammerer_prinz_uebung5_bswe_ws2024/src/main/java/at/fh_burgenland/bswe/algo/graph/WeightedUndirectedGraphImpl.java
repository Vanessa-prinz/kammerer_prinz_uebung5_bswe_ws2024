package at.fh_burgenland.bswe.algo.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeightedUndirectedGraphImpl implements WeightedUndirectedGraph {

    Set<String> vertexSet = new HashSet<>();
    List<Edge> edgeList = new ArrayList<>();


    public record Edge(String from, String to, int weight) {
    }

    @Override
    public void addVertex(String label) {
        vertexSet.add(label);
    }

    @Override
    public boolean hasVertex(String vertex) {
        return vertexSet.contains(vertex);
    }

    //TODO: Kanten entfernen
    @Override
    public void removeVertex(String vertex) {
        if (hasVertex(vertex)) {
            vertexSet.remove(vertex);
        } else {
            System.out.println("Vertex does not exist!");
        }
    }

    @Override
    public boolean hasEdge(String from, String to) {
        return edgeList.stream()
                .anyMatch(edge -> isMatchingEdge(from, to, edge));
    }

    @Override
    public void removeEdge(String from, String to) {
        if (hasEdge(from, to)) {
            edgeList.removeIf(edge -> isMatchingEdge(from, to, edge));
        } else {
            System.out.println("Edge does not exist!");
        }
    }

    @Override
    public List<String> getNeighbors(String vertex) {
        List<String> neighbors = new ArrayList<>();

        neighbors.addAll(edgeList.stream()
                .filter(edge -> edge.from.equals(vertex))
                .map(edge -> edge.to)
                .toList());
        neighbors.addAll(edgeList.stream()
                .filter(edge -> edge.to.equals(vertex))
                .map(edge -> edge.from)
                .toList());

        return neighbors;
    }

    @Override
    public Set<String> getVertices() {
        return vertexSet;
    }

    @Override
    public int getNumberOfVertices() {
        return vertexSet.size();
    }

    @Override
    public int getNumberOfEdges() {
        return edgeList.size();
    }

    @Override
    public void addEdge(String from, String to, int weight) {
        if (hasEdge(from, to)) {
            System.out.println("Edge already exists!");
        } else {
            edgeList.add(new Edge(from, to, weight));
        }
    }

    @Override
    public int getWeight(String from, String to) {
        if (hasEdge(from, to)) {
            return edgeList.stream()
                    .filter(edge -> isMatchingEdge(from, to, edge))
                    .findFirst().get().weight;
        } else {
            throw new RuntimeException("Edge does not exist");
        }
    }

    private static boolean isMatchingEdge(String from, String to, Edge edge) {
        return (edge.from.equals(from) && edge.to.equals(to))
                || (edge.from.equals(to) && edge.to.equals(from));
    }
}