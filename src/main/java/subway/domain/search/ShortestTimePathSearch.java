package subway.domain.search;

import java.util.List;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.TimeRepository;

public class ShortestTimePathSearch extends PathSearch {
    @Override
    public List<String> search(String departure, String arrival) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = SubwayMap.provideGraph();
        setTimeWeightEdge(graph);
        return findOptimizePath(graph, departure, arrival);
    }

    private void setTimeWeightEdge(WeightedMultigraph<String, DefaultWeightedEdge> graph) {
        TimeRepository.times().forEach(
                time -> graph.setEdgeWeight(graph.addEdge(time.getDeparture(), time.getArrival()),
                        time.getMinute())
        );
    }
}
