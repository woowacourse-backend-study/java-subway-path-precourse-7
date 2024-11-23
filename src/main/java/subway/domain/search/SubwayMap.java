package subway.domain.search;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.StationRepository;

public class SubwayMap {

    public static WeightedMultigraph<String, DefaultWeightedEdge> provideGraph() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        StationRepository.stations().forEach(station -> graph.addVertex(station.getName()));

        return graph;
    }
}
