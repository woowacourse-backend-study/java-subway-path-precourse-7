package subway.controller.vo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum PathStandardOption {
    DISTANCE("1", "1. 최단 거리"),
    TIME("2", "2. 최소 시간"),
    GO_BACK("B", "B. 돌아가기"),
    ;
    private final String value;
    private final String title;

    private PathStandardOption(String value, String title) {
        this.value = value;
        this.title = title;
    }

    public static Optional<PathStandardOption> from(String input) {
        return Arrays.stream(values())
                .filter(v -> v.getValue().equals(input))
                .findFirst();
    }

    public String getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public static List<String> getTitles() {
        return Arrays.stream(values())
                .map(PathStandardOption::getTitle)
                .toList();
    }
}
