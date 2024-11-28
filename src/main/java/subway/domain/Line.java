package subway.domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private String name;
    private List<Edge> edges;

    public Line(String name, List<Edge> edges) {
        this.name = name;
        this.edges = edges;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public List<Edge> getEdges() {
        return Collections.unmodifiableList(edges);
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }
}
