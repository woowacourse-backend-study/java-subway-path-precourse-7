package subway.domain;

import java.util.HashMap;
import java.util.Map;

public class PathTable {

    private String sourceName;
    private Map<String, Path> pathMap = new HashMap<>();

    public PathTable(String sourceName) {
        this.sourceName = sourceName;
    }

    public void updateTable(Track track, PathPolicy pathPolicy) {
        if (pathMap.get(track.getDestinationName()) == null) {
            if (track.getDestinationName().equals(sourceName)) {
                return;
            }
            Path sourcePath = findPath(track.getSourceName());
            if (sourcePath == null) {
                Path path = new Path(track);
                pathMap.put(track.getDestinationName(), path);
                return;
            }
            Path path = new Path(track, sourcePath);

            pathMap.put(track.getDestinationName(), path);
            return;
        }

        Path destinationPath = findPath(track.getDestinationName());

        Path sourcePath = findPath(track.getSourceName());
        Path path = new Path(track, sourcePath);
        if (pathPolicy.isBetterThan(path, destinationPath)) {
            pathMap.put(track.getDestinationName(), path);
        }
    }

    public Path findPath(String destinationName) {
        return pathMap.get(destinationName);
    }

}
