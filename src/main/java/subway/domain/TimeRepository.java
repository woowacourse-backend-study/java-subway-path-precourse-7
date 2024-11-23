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
                time -> Objects.equals(time.getDeparture(), departure) &&
                        Objects.equals(time.getArrival(), arrival));
    }

    public static void deleteAll() {
        times.clear();
    }

    public static int searchTimeByName(String departure, String arrival) {
        return times().stream()
                .filter(time -> Objects.equals(time.getDeparture(), departure) && Objects.equals(time.getArrival(),
                        arrival))
                .mapToInt(Time::getMinute).sum();
    }
}
