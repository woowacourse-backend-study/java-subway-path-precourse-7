package subway.service;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.*;
import subway.infrastructure.constants.ExceptionMessage;
import subway.infrastructure.exception.CustomException;
import subway.service.dto.PathResult;

import java.util.List;
import java.util.Optional;

public abstract class PathService {
    protected final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph =
            new WeightedMultigraph<>(DefaultWeightedEdge.class);
    protected final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph =
            new WeightedMultigraph<>(DefaultWeightedEdge.class);

    protected void initGraph() {
        initStations();
        initGraphs();
    }

    private void initStations() {
        List<Station> stations = StationRepository.findAll();
        for (Station station : stations) {
            distanceGraph.addVertex(station.getName());
            timeGraph.addVertex(station.getName());
        }
    }

    private void initGraphs() {
        List<Edge> edges = LineRepository.findAllEdge();
        for (Edge edge : edges) {
            distanceGraph.setEdgeWeight(
                    distanceGraph.addEdge(edge.startStationName(), edge.endStationName()), edge.distance()
            );
            timeGraph.setEdgeWeight(
                    timeGraph.addEdge(edge.startStationName(), edge.endStationName()), edge.time()
            );
        }
    }

    protected Path findPath(String start, String end) {
        return null;
    };

    public PathResult getPathResult(String start, String end) {
        Path path = findPath(start, end);
        if (path == null) {
            throw new CustomException(ExceptionMessage.NOT_EXIST_PATH.getMessage());
        }

        int distance = 0;
        int time = 0;
        List<Station> stations = path.value();
        for (int i = 0; i < stations.size() - 1; ++i) {
            Station startStation = stations.get(i);
            Station endStation = stations.get(i+1);
            Optional<Edge> edge = LineRepository.findEdgeByStations(startStation, endStation);
            if (edge.isEmpty()) {
                throw new RuntimeException("잘못된 경로로 조회되었습니다.");
            }
            distance += edge.get().distance();
            time += edge.get().time();
        }
        return new PathResult(path, distance, time);
    }
}
