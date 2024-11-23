package subway.service;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeGraphService {
    private final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph;
    private final Map<DefaultWeightedEdge, Double> distanceMap;

    public TimeGraphService() {
        timeGraph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        distanceMap = new HashMap<>();
        initializeGraph();
    }

    private void initializeGraph() {
        timeGraph.addVertex("교대역");
        timeGraph.addVertex("강남역");
        timeGraph.addVertex("역삼역");
        timeGraph.addVertex("남부터미널역");
        timeGraph.addVertex("양재역");
        timeGraph.addVertex("매봉역");
        timeGraph.addVertex("양재시민의숲역");

        addEdge("교대역", "강남역", 3, 2);
        addEdge("강남역", "역삼역", 3, 2);

        addEdge("교대역", "남부터미널역", 2, 3);
        addEdge("남부터미널역", "양재역", 5, 6);
        addEdge("양재역", "매봉역", 1, 1);

        addEdge("강남역", "양재역", 8, 2);
        addEdge("양재역", "양재시민의숲역", 3, 10);
    }

    private void addEdge(String from, String to, int time, double distance) {
        DefaultWeightedEdge edge = timeGraph.addEdge(from, to);
        timeGraph.setEdgeWeight(edge, time);
        distanceMap.put(edge, distance);
    }

    public List<String> getFastestPath(String start, String end) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraFastestPath = new DijkstraShortestPath<>(timeGraph);
        return dijkstraFastestPath.getPath(start, end).getVertexList();
    }

    public double getFastestTime(String start, String end) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(timeGraph);
        return dijkstraShortestPath.getPath(start, end).getWeight();
    }

    public double getTotalDistance(String start, String end) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(timeGraph);

        List<DefaultWeightedEdge> edges = dijkstraShortestPath.getPath(start, end).getEdgeList();

        return edges.stream().mapToDouble(distanceMap::get).sum();
    }
}
