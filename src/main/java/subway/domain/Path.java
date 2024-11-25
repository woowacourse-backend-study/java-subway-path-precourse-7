package subway.domain;

import java.util.ArrayList;
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

    public Path(Track track) {
        sourceName = track.getSourceName();
        destinationName = track.getDestinationName();
        tracks = new ArrayList<>();
        tracks.add(track);
        totalPrice = track.getPrice();
        totalDistance = track.getDistance();
    }

    public Path(Track track, Path sourcePath) {
        sourceName = sourcePath.sourceName;
        destinationName = track.getDestinationName();
        tracks = new ArrayList<>();
        tracks.addAll(sourcePath.tracks);
        tracks.add(track);
        totalPrice = sourcePath.totalPrice + track.getPrice();
        totalDistance = sourcePath.totalDistance + track.getDistance();
    }

    public boolean isLowPriceThan(Path path) {
        return totalDistance <= path.totalDistance;
    }

    public boolean isShortDistanceThan(Path path) {
        return totalDistance <= path.totalDistance;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[INFO] ---\n");
        stringBuilder.append(String.format("[INFO] 총 거리: %dkm\n", totalDistance));
        stringBuilder.append(String.format("[INFO] 총 소요 시간: %d분\n", totalPrice));
        stringBuilder.append("[INFO] ---\n");
        for (Track track : tracks) {
            stringBuilder.append(track);
        }
        stringBuilder.append(String.format("[INFO] %s\n", destinationName));
        return stringBuilder.toString();
    }
}
