package subway.domain.search;

import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.DistanceRepository;

public class ShortestDistancePathSearch extends PathSearch {
    @Override
    public List<String> search(String departure, String arrival) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = SubwayMap.provideGraph();
        setDistanceWeightEdge(graph);
        return findOptimizePath(graph, departure, arrival);
    }

    private void setDistanceWeightEdge(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        DistanceRepository.distances().forEach(
                distance -> graph.setEdgeWeight(graph.addEdge(distance.getDeparture(), distance.getArrival()),
                        distance.getKilometer())
        );
    }
}
