package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TimeRepository {
    private static final List<Time> times = new ArrayList<>();

    public static List<Time> times() {
        return Collections.unmodifiableList(times);
    }

    public static void addTime(Time time) {
        times.add(time);
    }

    public static boolean deleteTimeByName(String departure, String arrival) {
        return times.removeIf(
                distance -> Objects.equals(distance.getDeparture(), departure) &&
                        Objects.equals(distance.getArrival(), arrival));
    }

    public static void deleteAll() {
        times.clear();
    }
}
