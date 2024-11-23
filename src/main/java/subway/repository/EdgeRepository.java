package subway.repository;

import subway.domain.vo.Edge;
import subway.domain.vo.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EdgeRepository {
    private static final List<Edge> edges = new ArrayList<>();

    public static List<Edge> edges() {
        return Collections.unmodifiableList(edges);
    }

    public static void addEdge(Edge edge) {
        edges.add(edge);
    }

    public static void deleteAll() {
        edges.clear();
    }

    public static void addAll(List<Edge> edges) {
        EdgeRepository.edges.addAll(edges);
    }

    public static int getDistanceByStations(Station station1, Station station2) {
        return edges().stream()
                .filter(edge -> edge.isMatch(station1, station2))
                .findFirst()
                .orElseThrow()
                .distance();
    }

    public static int getTimeByStations(Station station1, Station station2) {
        return edges().stream()
                .filter(edge -> edge.isMatch(station1, station2))
                .findFirst()
                .orElseThrow()
                .time();
    }
}
