package subway.domain.path;


import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;
import subway.domain.Section;
import subway.domain.Station;

public class ShortestDistancePath implements ShortestPath {
    private final DijkstraShortestPath<Station, DefaultWeightedEdge> dijkstraPath;

    public ShortestDistancePath(List<Station> stations, List<Section> sections) {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = createGraph(stations, sections);
        this.dijkstraPath = new DijkstraShortestPath<>(graph);
    }

    private WeightedMultigraph<Station, DefaultWeightedEdge> createGraph(List<Station> stations, List<Section> sections) {
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        for (Station station : stations) {
            graph.addVertex(station);
        }
        for (Section section : sections) {
            graph.setEdgeWeight(graph.addEdge(section.getLeft(), section.getRight()), section.getDistance());
        }
        return graph;
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