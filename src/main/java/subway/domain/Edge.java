package subway.domain;

import subway.infrastructure.constants.ExceptionMessage;
import subway.infrastructure.exception.CustomException;

public record Edge(Station start, Station end, int distance, int time) {
    public static int MIN_DISTANCE = 1;
    public static int MAX_DISTANCE = 1000;
    public static int MIN_TIME = 1;
    public static int MAX_TIME = 100;

    public Edge {
        validateDistance(distance);
        validateTime(time);
    }

    public static Edge from(String start, String end, int distance, int time) {
        return new Edge(new Station(start), new Station(end), distance, time);
    }

    public String startStationName() {
        return start.getName();
    }

    public String endStationName() {
        return end.getName();
    }

    private void validateDistance(int distance) {
        if (distance < MIN_DISTANCE || distance > MAX_DISTANCE) {
            throw new CustomException(ExceptionMessage.INVALID_DISTANCE.getMessage());
        }
    }

    private void validateTime(int time) {
        if (time < MIN_TIME || time > MAX_TIME) {
            throw new CustomException(ExceptionMessage.INVALID_TIME.getMessage());
        }
    }

    public boolean isMatch(Station a, Station b) {
        if (a.equals(start) && b.equals(end)
                || a.equals(end) && b.equals(start)) {
            return true;
        }
        return false;
    }
}
