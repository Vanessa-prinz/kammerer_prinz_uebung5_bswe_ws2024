package at.fh_burgenland.bswe.algo.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class is the implementation of a weighted directed graph.
 */
public class WeightedDirectedGraphImpl implements WeightedDirectedGraph {

    Set<String> vertexSet = new HashSet<>();
    List<Edge> edgeList = new ArrayList<>();

    /**
     * This method adds a vertex to the graph.
     *
     * @param label the label of the vertex
     */
    @Override
    public void addVertex(String label) {
        vertexSet.add(label);
    }

    /**
     * This method checks if the graph contains the specific vertex.
     *
     * @param vertex the vertex to check for
     * @return true if the vertex exists, false if otherwise
     */
    @Override
    public boolean hasVertex(String vertex) {
        return vertexSet.contains(vertex);
    }

    /**
     * This method removes a vertex from the graph.
     *
     * @param vertex the vertex to remove
     */
    @Override
    public void removeVertex(String vertex) {
        if (hasVertex(vertex)) {
            vertexSet.remove(vertex);
        } else {
            System.out.println("Vertex does not exist!");
        }
    }

    /**
     * This method adds an edge with a specific weight between two vertices.
     *
     * @param from   the source vertex
     * @param to     the destination vertex
     * @param weight the weight of the edge
     */
    @Override
    public void addEdge(String from, String to, int weight) {
        if (hasEdge(from, to)) {
            System.out.println("Edge already exists!");
        } else {
            edgeList.add(new Edge(from, to, weight));
        }
    }

    /**
     * This method gets the weight of an edge between to vertices.
     *
     * @param from the source vertex
     * @param to   the destination vertex
     * @return the weight of the edge
     */
    @Override
    public int getWeight(String from, String to) {
        if (hasEdge(from, to)) {
            return edgeList.stream()
                    .filter(edge -> edge.from().equals(from) && edge.to().equals(to))
                    .findFirst().get().weight();
        } else {
            throw new RuntimeException("Edge does not exist.");
        }
    }

    /**
     * This method checks if an edge exists between two vertices.
     *
     * @param from the source vertex
     * @param to   the destination vertex
     * @return true if the edge exists, false if otherwise
     */
    @Override
    public boolean hasEdge(String from, String to) {
        return edgeList.stream()
                .anyMatch(edge -> edge.from().equals(from) && edge.to().equals(to));
    }

    /**
     * This method removes an edge between two vertices.
     *
     * @param from the source vertex
     * @param to   the destination vertex
     */
    @Override
    public void removeEdge(String from, String to) {
        if (hasEdge(from, to)) {
            edgeList.removeIf(edge -> edge.from().equals(from) && edge.to().equals(to));
        } else {
            System.out.println("Edge does not exist!");
        }
    }

    /**
     * This method gets the neighbors of a specific vertex.
     *
     * @param vertex the vertex to get the neighbors for
     * @return a list of neighbors from the given vertex
     */
    @Override
    public List<String> getNeighbors(String vertex) {
        return edgeList.stream()
                .filter(edge -> edge.from().equals(vertex))
                .map(edge -> edge.to())
                .toList();
    }

    /**
     * This method gets all vertices of the graph.
     *
     * @return a set of all vertices
     */
    @Override
    public Set<String> getVertices() {
        return vertexSet;
    }

    /**
     * This method gets the number of vertices in the graph.
     *
     * @return the number of vertices
     */
    @Override
    public int getNumberOfVertices() {
        return vertexSet.size();
    }

    /**
     * This method gets the number of edges in the graph.
     *
     * @return the number of edges
     */
    @Override
    public int getNumberOfEdges() {
        return edgeList.size();
    }
}