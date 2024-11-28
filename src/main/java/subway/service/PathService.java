package subway.service;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.*;

import java.util.List;

public abstract class PathService {
    protected final List<Station> stations = StationRepository.findAll();
    protected final List<Edge> edges = LineRepository.findAllEdge();
    protected final WeightedMultigraph<String, DefaultWeightedEdge> distanceGraph =
            new WeightedMultigraph<>(DefaultWeightedEdge.class);
    protected final WeightedMultigraph<String, DefaultWeightedEdge> timeGraph =
            new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public PathService() {
        initStations();
        initGraphs();
    }

    private void initStations() {
        for (Station station : stations) {
            distanceGraph.addVertex(station.getName());
            timeGraph.addVertex(station.getName());
        }
    }

    private void initGraphs() {
        for (Edge edge : edges) {
            distanceGraph.setEdgeWeight(
                    distanceGraph.addEdge(edge.startStationName(), edge.endStationName()), edge.distance()
            );
            timeGraph.setEdgeWeight(
                    timeGraph.addEdge(edge.startStationName(), edge.endStationName()), edge.distance()
            );
        }
    }

    public Path findPath(String start, String end) {
        return null;
    };
}
