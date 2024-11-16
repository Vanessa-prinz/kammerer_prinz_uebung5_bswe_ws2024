package at.fh_burgenland.bswe.algo.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WeightedDirectedGraphImpl implements WeightedDirectedGraph {

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
                .anyMatch(edge -> edge.from.equals(from) && edge.to.equals(to));
    }

    @Override
    public void removeEdge(String from, String to) {
        if (hasEdge(from, to)) {
            edgeList.removeIf(edge -> edge.from.equals(from) && edge.to.equals(to));
        } else {
            System.out.println("Edge does not exist!");
        }
    }

    @Override
    public List<String> getNeighbors(String vertex) {
        return edgeList.stream()
                .filter(edge -> edge.from.equals(vertex))
                .map(edge -> edge.to)
                .toList();
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
                    .filter(edge -> edge.from.equals(from) && edge.to.equals(to))
                    .findFirst().get().weight;
        } else {
            throw new RuntimeException("Edge does not exist");
        }
    }
}