package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrackRepository {
    private static final List<Track> stations = new ArrayList<>();

    public static List<Track> stations() {
        return Collections.unmodifiableList(stations);
    }
}
