package subway.domain.path;

import subway.domain.Station;

public class ShortestParhValidator {
    private static final String INVALID_START_END_STATIONS = "[ERROR] 출발역과 도착역이 같을 수 없습니다.";
    public static void validateIsEqualStations(Station start, Station end) {
        if (start.equals(end)) {
            throw new IllegalArgumentException(INVALID_START_END_STATIONS);
        }
    }
}
