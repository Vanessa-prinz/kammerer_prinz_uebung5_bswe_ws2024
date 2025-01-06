package at.fh_burgenland.bswe.algo.graph;

/**
 * This record represents an edge in a graph with a source, destination and weight.
 * @param from the source
 * @param to the destination
 * @param weight the weight of the edge
 */
public record Edge(String from, String to, int weight) {

}