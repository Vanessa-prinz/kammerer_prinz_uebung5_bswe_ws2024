package at.fh_burgenland.bswe.algo.algorithm;

import at.fh_burgenland.bswe.algo.graph.WeightedDirectedGraph;

import java.util.*;

/**
 * This class provides methods to calculate the shortest path in a weighted directed graph using the Dijkstra algorithm.
 */
public class Dijkstra {
     /**
     * Calculates the shortest path from the start vertex to all other vertices in the graph.
     *
     * @param graph The graph to calculate the shortest path on
     * @param start The start vertex
     * @return A map containing the shortest distances from the start vertex to all other vertices
     */
    public static Map<String, Integer> dijkstra(WeightedDirectedGraph graph, String start) {
        Map<String, Integer> distancesToStart = new HashMap<>();
        Map<String, String> predecessors = new HashMap<>();
        Set<String> visitedLocations = new HashSet<>();
        Queue<String> locationsToBeVisitedNext = new PriorityQueue<>(Comparator.comparingInt(distancesToStart::get));

        if (graph == null || !graph.hasVertex(start))
            return Collections.emptyMap();

        for (String vertex : graph.getVertices()) {
            distancesToStart.put(vertex, Integer.MAX_VALUE);
        }
        distancesToStart.put(start, 0);

        locationsToBeVisitedNext.add(start);

        while (!locationsToBeVisitedNext.isEmpty()) {
            String currentLocation = locationsToBeVisitedNext.poll();
            if (visitedLocations.contains(currentLocation))
                continue;
            visitedLocations.add(currentLocation);

            for (String neighbor : graph.getNeighbors(currentLocation)) {
                if (visitedLocations.contains(neighbor))
                    continue;
                int edgeWeight = graph.getWeight(currentLocation, neighbor);
                int newDistanceToNeigbor = distancesToStart.get(currentLocation) + edgeWeight;
                if (newDistanceToNeigbor < distancesToStart.get(neighbor)) {
                    distancesToStart.put(neighbor, newDistanceToNeigbor);
                    predecessors.put(neighbor, currentLocation);
                    locationsToBeVisitedNext.add(neighbor);
                }
            }
        }

        return distancesToStart;
    }

    /**
     * Returns the shortest path from the start vertex to the end vertex.
     * format: ["A", "B", "C", ...]
     *
     * @param graph     The graph to calculate the shortest path on
     * @param start     The start vertex
     * @param end       The end vertex
     * @return A list containing the vertices of the shortest path from the start vertex to the end vertex
     */
    public static List<String> getShortestPath(WeightedDirectedGraph graph, String start, String end) {
//        alles von vorn, weil ich meine Predecessors nicht habe
        Map<String, Integer> distancesToStart = new HashMap<>();
        Map<String, String> predecessors = new HashMap<>();
        Set<String> visitedLocations = new HashSet<>();
        Queue<String> locationsToBeVisitedNext = new PriorityQueue<>(Comparator.comparingInt(distancesToStart::get));

        if (graph == null || !graph.hasVertex(start) || !graph.hasVertex(end)) {
            return new ArrayList<>();
        }

        for (String vertex : graph.getVertices()) {
            distancesToStart.put(vertex, Integer.MAX_VALUE);
        }
        distancesToStart.put(start, 0);

        locationsToBeVisitedNext.add(start);

        while (!locationsToBeVisitedNext.isEmpty()) {
            String currentLocation = locationsToBeVisitedNext.poll();
            if (visitedLocations.contains(currentLocation)) {
                continue;
            }
            visitedLocations.add(currentLocation);

            for (String neighbor : graph.getNeighbors(currentLocation)) {
                if (visitedLocations.contains(neighbor)) {
                    continue;
                }
                int edgeWeight = graph.getWeight(currentLocation, neighbor);
                int newDistanceToNeighbor = distancesToStart.get(currentLocation) + edgeWeight;
                if (newDistanceToNeighbor < distancesToStart.get(neighbor)) {
                    distancesToStart.put(neighbor, newDistanceToNeighbor);
                    predecessors.put(neighbor, currentLocation);
                    locationsToBeVisitedNext.add(neighbor);
                }
            }
        }

//        getShortestPath-Part
        List<String> shortestPath = new ArrayList<>();
        String currentLocation = end;

        while (currentLocation != null && !currentLocation.equals(start)) {
            shortestPath.add(0, currentLocation);
            currentLocation = predecessors.get(currentLocation);
        }

        if (currentLocation == null) {
            return new ArrayList<>(); // Kein gültiger Pfad gefunden
        }

        shortestPath.add(0, start);
        return shortestPath;
    }

//    getShortestPath wenn wir die Predecessors mitübergeben könnten
//    /**
//     * Returns the shortest path from the start vertex to the end vertex.
//     * format: ["A", "B", "C", ...]
//     *
//     * @param graph     The graph to calculate the shortest path on
//     * @param predecessors A map containing the predecessors to all other vertices than the start for reconstructing the shortest path
//     * @param start     The start vertex
//     * @param end       The end vertex
//     * @return A list containing the vertices of the shortest path from the start vertex to the end vertex
//     */
//    public static List<String> getShortestPath(WeightedDirectedGraph graph, Map<String, String> predecessors, String start, String end) {
//        List<String> shortestPath = new ArrayList<>();
//        if (!graph.hasVertex(start)
//                || !graph.hasVertex(end)
//                || !predecessors.containsValue(end))
//            return shortestPath;
//
//        String currentLocation = end;
//        while (currentLocation !=null) {
//            shortestPath.add(0, currentLocation);
//            for (String neighbor : graph.getNeighbors(currentLocation)) {}
//            currentLocation = predecessors.get(currentLocation);
//        }
//        return null;
//    }
}