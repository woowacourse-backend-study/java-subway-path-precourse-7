package subway.domain;

import static subway.enums.ExceptionMessage.NOT_EXISTS_STATION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

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

    public static String searchStationByName(String name) {
        if (!stations.contains(new Station(name))) {
            throw new IllegalArgumentException(NOT_EXISTS_STATION.valueOf());
        }
        return name;
    }
}
