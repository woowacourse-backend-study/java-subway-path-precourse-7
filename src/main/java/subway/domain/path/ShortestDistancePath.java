package subway.domain.path;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;
import subway.domain.Section;
import subway.domain.Station;

public class ShortestDistancePath implements ShortestPath {
    private final DijkstraShortestPath<Station, CustomWeightedEdge> dijkstraPath;

    public ShortestDistancePath(List<Station> stations, List<Section> sections) {
        WeightedMultigraph<Station, CustomWeightedEdge> graph = createGraph(stations, sections);
        this.dijkstraPath = new DijkstraShortestPath<>(graph);
    }

    private WeightedMultigraph<Station, CustomWeightedEdge> createGraph(List<Station> stations, List<Section> sections) {
        WeightedMultigraph<Station, CustomWeightedEdge> graph = new WeightedMultigraph<>( CustomWeightedEdge.class);
        addVertex(stations, graph);
        addEdge(sections,graph);
        return graph;
    }

    private void addVertex(List<Station> stations, WeightedMultigraph <Station,CustomWeightedEdge> graph) {
        for (Station station : stations) {
            graph.addVertex(station);
        }
    }
    private void addEdge(List<Section> sections, WeightedMultigraph <Station,CustomWeightedEdge> graph) {
        for (Section section : sections) {
            graph.setEdgeWeight(graph.addEdge(section.getLeft(), section.getRight()), section.getDistance());

        }
    }

    @Override
    public PathResult calculatePath(Station start, Station end) {
        ShortestParhValidator.validateIsEqualStations(start, end);
        GraphPath<Station, CustomWeightedEdge> path = dijkstraPath.getPath(start, end);
        return new PathResult((int) path.getWeight(),path. getVertexList(),path.getEdgeList());
    }

}