package at.fh_burgenland.bswe.algo.algorithm;

import at.fh_burgenland.bswe.algo.graph.WeightedDirectedGraph;

import java.util.*;

public class Dijkstra {
    /*
    nachfolger je ausgewählten, liste erledigte

    alle entfernungen von best. ausgangspunkt auf unendlich setzen
    kosten zu startknoten 0

    warteschlange zunächst nur mit startknoten
    nachfolgerliste mit anliegenden befüllen

    ersten aus warteschlange wählen -> gewichtung zu nachfolgern eintragen, wenn kürzer als bisherige
    vorgänger immer dazu eintragen
    nachfolger in warteschlange aufnehmen & erledigten eintragen

    den aus der warteschlange wählen, wo kosten bisher am geringsten
    wieder gewichtung zu nachfolgern und ggf ersetzen (mit vorgänger)
    usw.

    bis alle
     */

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
        distancesToStart.put(start, 0); //TODO-Startknoten damit eh nicht doppelt??

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
     * @param distances A map containing the shortest distances from the start vertex to all other vertices
     * @param start     The start vertex
     * @param end       The end vertex
     * @return A list containing the vertices of the shortest path from the start vertex to the end vertex
     */
    public static List<String> getShortestPath(WeightedDirectedGraph graph, Map<String, Integer> distances, String start, String end) {
        List<String> shortestPath = new ArrayList<>();
        if (graph == null
                || !graph.hasVertex(start)
                || !graph.hasVertex(end)
                || !distances.containsKey(start)
                || !distances.containsKey(end)
                || distances.get(end) == Integer.MAX_VALUE)
            return shortestPath;

        String currentLocation = end;
        while (currentLocation !=null && !currentLocation.equals(start)) {
            shortestPath.add(0, currentLocation);

            boolean foundProdecessor = false;
            for (String neighbor : graph.getIncomingNeighbors(currentLocation)) {
                //TODO-Voraussetzung wir dürfen neue Methoden zu WeightedDirectedGraph hinzufügen
                int edgeWeight = graph.getWeight(neighbor, currentLocation);
                if (distances.get(currentLocation) - edgeWeight == distances.get(neighbor)) {
                    currentLocation = neighbor;
                    foundProdecessor = true;
                    break;
                }
            }
            if (!foundProdecessor)
                return new ArrayList<>();
        }

        shortestPath.add(0, start);
        return shortestPath;
    }

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
