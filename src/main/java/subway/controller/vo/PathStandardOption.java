package subway.controller.vo;

import java.util.Arrays;
import java.util.List;

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

    public String getValue() {
        return value;
    }

    public List<String> getTitles() {
        return Arrays.stream(values()).map(v -> v.title).toList();
    }
}
