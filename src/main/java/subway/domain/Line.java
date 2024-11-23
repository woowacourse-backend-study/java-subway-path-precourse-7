package subway.domain;

import java.util.Arrays;
import java.util.List;

public class Line {

    private final String name;
    private final List<Station> stations;

    private Line(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public static Line valueOf(String input, Station... stations) {
        return new Line(input, Arrays.stream(stations).toList());
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
