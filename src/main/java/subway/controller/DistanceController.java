package subway.controller;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.view.OutputView;

public class DistanceController {
    WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph = new WeightedMultigraph(DefaultWeightedEdge.class);
    WeightedMultigraph<String, DefaultWeightedEdge> hourGraph = new WeightedMultigraph(DefaultWeightedEdge.class);

    public DistanceController(String startStation, String endStation) {
        initHourAndDistance();
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(distanceGraph);
        List<String> shortestPath = dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        int shortestDistance = (int) dijkstraShortestPath.getPath(startStation, endStation).getWeight();
        int totalTime = checkTime(shortestPath);
        OutputView.printResult(shortestDistance, totalTime, shortestPath);
    }

    private int checkTime(List<String> shortestPath) {
        DijkstraShortestPath path = new DijkstraShortestPath(hourGraph);
        int result = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            String startStation = shortestPath.get(i);
            String endStation = shortestPath.get(i + 1);
            result += (int) path.getPath(startStation, endStation).getWeight();
        }
        return result;
    }

    private void initHourAndDistance() {
        List<Station> stations = StationRepository.stations();
        for (Station station : stations) {
            String name = station.getName();
            distanceGraph.addVertex(name);
            hourGraph.addVertex(name);
        }
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("교대역", "강남역"), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("교대역", "남부터미널역"), 3);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("양재역", "남부터미널역"), 6);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("양재역", "매봉역"), 1);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("양재역", "양재시민의숲역"), 10);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("역삼역", "강남역"), 2);
        distanceGraph.setEdgeWeight(distanceGraph.addEdge("양재역", "강남역"), 2);
        hourGraph.setEdgeWeight(hourGraph.addEdge("교대역", "강남역"), 3);
        hourGraph.setEdgeWeight(hourGraph.addEdge("교대역", "남부터미널역"), 2);
        hourGraph.setEdgeWeight(hourGraph.addEdge("양재역", "남부터미널역"), 5);
        hourGraph.setEdgeWeight(hourGraph.addEdge("양재역", "매봉역"), 1);
        hourGraph.setEdgeWeight(hourGraph.addEdge("양재역", "양재시민의숲역"), 3);
        hourGraph.setEdgeWeight(hourGraph.addEdge("역삼역", "강남역"), 3);
        hourGraph.setEdgeWeight(hourGraph.addEdge("양재역", "강남역"), 8);
    }

}
