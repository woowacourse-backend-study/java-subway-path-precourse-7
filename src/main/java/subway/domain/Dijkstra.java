package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Dijkstra {

    private Station sourceStation;
    private PathTable pathTable;
    private VisitedTable visitedTable;
    private List<Track> dummyTracks;
    private PathPolicy pathPolicy;

    public Dijkstra(Station sourceStation, PathPolicy pathPolicy) {
        this.sourceStation = sourceStation;
        pathTable = new PathTable(sourceStation.getName());
        visitedTable = new VisitedTable(sourceStation, StationRepository.stations());
        this.dummyTracks = new ArrayList<>();
        this.pathPolicy = pathPolicy;

        update(sourceStation);
        //dummyTracks.addAll(sourceStation.getTracks());

    }

    public void calculatePath() {
        while (dummyTracks.size() != 0) {
            Track policyTrack = pathPolicy.getPolicyTrack(dummyTracks);
            dummyTracks.remove(policyTrack);
            Station destinationStation = StationRepository.findByName(policyTrack.getDestinationName());
            if (visitedTable.isVisited(destinationStation)) {
                continue;
            }
            visitedTable.visited(destinationStation);
            update(destinationStation);
        }
    }

    private void update(Station updateStation) {
        List<Track> updateTracks = updateStation.getTracks();
        dummyTracks.addAll(updateTracks);
        for (Track updateTrack : updateTracks) {
            pathTable.updateTable(updateTrack, pathPolicy);
        }
    }

    public Path getShortestPath(String stationName) {
        return pathTable.findPath(stationName);
    }
}
