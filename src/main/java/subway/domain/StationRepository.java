package subway.domain;

import java.util.*;

public class StationRepository {
    private static final List<Station> stations = new ArrayList<>();

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static void deleteAll() {
        stations.clear();
    }

    public static Optional<Station> findStation(String name) {
        return stations.stream()
                .filter(s -> s.getName().equals(name))
                .findFirst();
    }

    public static List<Station> findAll() {
        return Collections.unmodifiableList(stations);
    }
}
