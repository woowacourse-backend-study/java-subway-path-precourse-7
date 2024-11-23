package subway.domain.search;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public abstract class PathSearch {
    protected abstract List<String> search(String departure, String arrival);

    protected List<String> findOptimizePath(WeightedMultigraph<String, DefaultWeightedEdge> graph, String departure,
                                            String arrival) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        return dijkstraShortestPath.getPath(departure, arrival).getVertexList();
    }
}
