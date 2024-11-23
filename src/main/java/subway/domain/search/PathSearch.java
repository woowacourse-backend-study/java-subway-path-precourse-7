package subway.domain.search;

import static subway.enums.ExceptionMessage.NOT_CONNECTED_PATH;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

public abstract class PathSearch {
    protected abstract List<String> search(String departure, String arrival);

    protected List<String> findOptimizePath(WeightedMultigraph<String, DefaultWeightedEdge> graph, String departure,
                                            String arrival) {
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath(departure, arrival).getVertexList();
        
        return checkConnectedGraph(shortestPath);
    }

    private List<String> checkConnectedGraph(List<String> shortestPath) {
        if (shortestPath.isEmpty()) {
            throw new IllegalArgumentException(NOT_CONNECTED_PATH.valueOf());
        }
        return shortestPath;
    }
}
