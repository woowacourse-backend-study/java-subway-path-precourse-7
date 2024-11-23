package subway.domain.path;

import java.util.List;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Section;
import subway.domain.Station;

public class ShortestTimePath implements ShortestPath {
    private final DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstraPath;

    public ShortestTimePath(List<Station> stations, List<Section> sections) {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = createGraph(stations, sections);
        this.dijkstraPath = new DijkstraShortestPath<>(graph);
    }

    private WeightedMultigraph<Station, DefaultWeightedEdge> createGraph(List<Station> stations, List<Section> sections) {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = initializeGraph(stations);
        addEdgesToGraph(graph, sections);
        return graph;
    }

    private WeightedMultigraph<Station, DefaultWeightedEdge> initializeGraph(List<Station> stations) {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        for (Station station : stations) {
            graph.addVertex(station);
        }
        return graph;
    }

    private void addEdgesToGraph(WeightedMultigraph<Station, DefaultWeightedEdge> graph, List<Section> sections) {
        for (Section section : sections) {
            graph.setEdgeWeight(graph.addEdge(section.getLeft(), section.getRight()), section.getTime());
        }
    }

    public PathResult calculatePath(Station start, Station end) {
        GraphPath<Station, DefaultWeightedEdge> path = dijkstraPath.getPath(start, end);
        return createPathResult(path);
    }

    private PathResult createPathResult(GraphPath<Station, DefaultWeightedEdge> path) {
        int weight = (int) path.getWeight();
        List<Station> vertices = path.getVertexList();
        List<DefaultWeightedEdge> edges = path.getEdgeList();
        return new PathResult(weight, vertices, edges);
    }
}