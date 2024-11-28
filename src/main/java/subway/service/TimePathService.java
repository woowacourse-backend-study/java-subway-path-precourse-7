package subway.service;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import subway.domain.*;
import subway.infrastructure.constants.ExceptionMessage;
import subway.infrastructure.exception.CustomException;

import java.util.List;
import java.util.Optional;

public class TimePathService extends PathService {
    @Override
    protected Path findPath(String start, String end) {
        initGraph();
        Optional<Station> startStation = StationRepository.findStation(start);
        Optional<Station> destStation = StationRepository.findStation(end);
        if (startStation.isEmpty() || destStation.isEmpty()) {
            throw new CustomException(ExceptionMessage.NOT_EXIST_STATION.getMessage());
        }
        return getPath(start, end);
    }

    private Path getPath(String start, String end) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(timeGraph);
        GraphPath graphPath = dijkstraShortestPath.getPath(start, end);
        if (graphPath == null) {
            throw new CustomException(ExceptionMessage.NOT_EXIST_PATH.getMessage());
        }
        List<String> path = graphPath.getVertexList();
        return Path.from(path);
    }
}
