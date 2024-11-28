package subway.domain;

import java.util.List;

public record Path(List<Station> path) {
    public static Path from(List<String> input) {
        List<Station> pathStations = input.stream()
                .map(Station::new)
                .toList();
        return new Path(pathStations);
    }
}
