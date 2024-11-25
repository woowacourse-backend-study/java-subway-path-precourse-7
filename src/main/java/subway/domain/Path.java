package subway.domain;

import java.util.List;

public class Path {

    private String sourceName;
    private String destinationName;
    private List<Track> tracks;
    private int totalDistance = 0;
    private int totalPrice = 0;

    public Path(String sourceName, String destinationName, List<Track> tracks) {
        this.sourceName = sourceName;
        this.destinationName = destinationName;
        this.tracks = tracks;
        for (Track track : tracks) {
            totalDistance += track.getDistance();
            totalPrice = track.getPrice();
        }
    }
}
