package subway.domain.path;

import org.jgrapht.graph.DefaultWeightedEdge;
import java.util.ArrayList;
import java.util.List;
import subway.domain.Station;

public class PathResult {
    private final int weight;
    private final List<Station> stations;
    private final List<List<String>> edgeStationNames;

    public PathResult(int weight, List<Station> stations, List<CustomWeightedEdge> sections) {
        this.weight = weight;
        this.stations = stations;
        this.edgeStationNames = new ArrayList<>();
        parsingEdgeStationsName(sections);
    }
    private void parsingEdgeStationsName(List<CustomWeightedEdge> sections) {
        for (CustomWeightedEdge edge : sections) {
            String edgeName = edge.toString();
            String stations = edge.toString();
            String[] split = stations.split(",");
            edgeStationNames.add(List.of(split [0], split[1]));
        }
    }
    public int getWeight() {
        return weight;
    }
    public List<Station> getStations() {
        return stations;
    }
    public List<List<String>> getEdgeStationNames() {
        return edgeStationNames;
    }
}