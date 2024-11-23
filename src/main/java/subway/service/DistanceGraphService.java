package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistanceGraphService {
    private final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph;
    private final Map<DefaultWeightedEdge, Double> timeMap;

    public DistanceGraphService() {
        distanceGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        timeMap = new HashMap<>();
        initializeGraph();
    }

    private void initializeGraph() {
        distanceGraph.addVertex("교대역");
        distanceGraph.addVertex("강남역");
        distanceGraph.addVertex("역삼역");
        distanceGraph.addVertex("남부터미널역");
        distanceGraph.addVertex("양재역");
        distanceGraph.addVertex("매봉역");
        distanceGraph.addVertex("양재시민의숲역");

        addEdge("교대역", "강남역", 2, 3);
        addEdge("강남역", "역삼역", 2, 3);

        addEdge("교대역", "남부터미널역", 3, 2);
        addEdge("남부터미널역", "양재역", 6, 5);
        addEdge("양재역", "매봉역", 1, 1);

        addEdge("강남역", "양재역", 2, 8);
        addEdge("양재역", "양재시민의숲역", 10, 3);
    }

    private void addEdge(String from, String to, double distance, double time) {
        DefaultWeightedEdge edge = distanceGraph.addEdge(from, to);
        distanceGraph.setEdgeWeight(edge, distance);
        timeMap.put(edge, time);
    }

    public List<String> getShortestPath(String start, String end) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(distanceGraph);
        return dijkstraShortestPath.getPath(start, end).getVertexList();
    }

    public double getShortestDistance(String start, String end) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(distanceGraph);
        return dijkstraShortestPath.getPath(start, end).getWeight();
    }

    public double getTotalTime(String start, String end) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(distanceGraph);

        List<DefaultWeightedEdge> edges = dijkstraShortestPath.getPath(start, end).getEdgeList();

        return edges.stream().mapToDouble(timeMap::get).sum();
    }
}
