package subway.domain;

import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.vo.Edge;
import subway.domain.vo.Path;
import subway.domain.vo.Station;

import java.util.List;

public class DistancePath {
    WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);

    public DistancePath(List<Station> stations, List<Edge> edges) {
        for (Station station : stations) {
            graph.addVertex(station.getName());
        }
        for (Edge edge : edges) {
            graph.setEdgeWeight(graph.addEdge(edge.station1().getName(), edge.station2().getName()), edge.distance());
        }
    }

    public Path getPath(String station1, String station2) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        GraphPath graphPath = dijkstraShortestPath.getPath(station1, station2);
        if (graphPath == null) {
            return null;
        }
        List<String> stringPath = graphPath.getVertexList();
        List<Station> path = stringPath.stream().map(Station::new).toList();
        return new Path(path);
    }
}
