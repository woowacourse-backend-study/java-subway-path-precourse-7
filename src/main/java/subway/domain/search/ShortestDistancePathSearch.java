package subway.domain.search;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.DistanceRepository;
import subway.domain.StationRepository;

public class ShortestDistancePathSearch implements PathSearch {
    @Override
    public List<String> search(String departure, String arrival) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        setStationVertex(graph);
        setDistanceWeightEdge(graph);
        return findOptimizePath(graph, departure, arrival);
    }

    private List<String> findOptimizePath(WeightedMultigraph<String, DefaultWeightedEdge> graph, String departure,
                                          String arrival) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        return dijkstraShortestPath.getPath(departure, arrival).getVertexList();
    }

    private void setStationVertex(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        StationRepository.stations().forEach(station -> graph.addVertex(station.getName()));
    }

    private void setDistanceWeightEdge(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        DistanceRepository.distances().forEach(
                distance -> graph.setEdgeWeight(graph.addEdge(distance.getDeparture(), distance.getArrival()),
                        distance.getKilometer())
        );
    }
}
