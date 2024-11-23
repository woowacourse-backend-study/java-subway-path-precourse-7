package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DistanceRepository {
    private static final List<Distance> distances = new ArrayList<>();

    public static List<Distance> distances() {
        return Collections.unmodifiableList(distances);
    }

    public static void addDistance(Distance distance) {
        distances.add(distance);
    }

    public static boolean deleteLineByName(String departure, String arrival) {
        return distances.removeIf(
                distance -> Objects.equals(distance.getDeparture(), departure) &&
                        Objects.equals(distance.getArrival(), arrival));
    }

    public static void deleteAll() {
        distances.clear();
    }
}
