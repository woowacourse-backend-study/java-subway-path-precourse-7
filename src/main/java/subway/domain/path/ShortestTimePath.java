package subway.domain.path;

import java.util.List;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.Section;
import subway.domain.Station;

public class ShortestTimePath implements ShortestPath {
    private final DijkstraShortestPath <Station, CustomWeightedEdge> dijkstraPath;

    public ShortestTimePath(List<Station> stations, List<Section> sections) {
        WeightedMultigraph<Station, CustomWeightedEdge> graph= new WeightedMultigraph<>(CustomWeightedEdge.class);
        this. dijkstraPath = new DijkstraShortestPath<>(graph);
    }
    private  WeightedMultigraph<Station, CustomWeightedEdge> creatGraph(List<Station> stations, List<Section> sections) {
        WeightedMultigraph<Station,CustomWeightedEdge> graph = new WeightedMultigraph<>(CustomWeightedEdge.class);
        addVertex(stations,graph);
        addEdge(sections, graph);
        return graph;
    }

    private void  addVertex(List<Station> stations, WeightedMultigraph<Station, CustomWeightedEdge> graph) {
        for (Station station : stations) {
            graph.addVertex(station);
        }
    }

    private void addEdge(List<Section> sections, WeightedMultigraph<Station, CustomWeightedEdge> graph) {
        for(Section section : sections) {
            graph.setEdgeWeight(graph.addEdge(section.getLeft(),section.getRight()),
                    section.getTime());
        }
    }


    @Override
    public PathResult calculatePath(Station start, Station end) {
        GraphPath<Station, CustomWeightedEdge> path = dijkstraPath.getPath(start, end);
        return new PathResult((int) path.getWeight(),path. getVertexList(),path.getEdgeList());
    }

}