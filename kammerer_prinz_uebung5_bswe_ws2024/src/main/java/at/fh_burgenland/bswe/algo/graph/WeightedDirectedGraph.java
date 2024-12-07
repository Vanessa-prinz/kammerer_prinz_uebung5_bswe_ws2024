package at.fh_burgenland.bswe.algo.graph;

import java.util.List;

public interface WeightedDirectedGraph extends WeightedGraph {
    List<String> getIncomingNeighbors(String vertex);
}
