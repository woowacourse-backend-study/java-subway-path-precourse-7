package subway.domain;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void deleteAll() {
        lines.clear();
    }

    public static List<Edge> findAllEdge() {
        List<Edge> edges = new ArrayList<>();
        for (Line line : lines) {
            edges.addAll(line.getEdges());
        }
        return Collections.unmodifiableList(edges);
    }

    public static Optional<Edge> findEdgeByStations(Station a, Station b) {
        List<Edge> edges = findAllEdge();
        return edges.stream()
                .filter(edge -> edge.isMatch(a, b))
                .findFirst();
    }
}
