package subway.controller.vo;

import java.util.Arrays;
import java.util.List;

public enum MainOption {
    CHECK_PATH("1", "1. 경로 조회"),
    EXIT("Q", "Q. 종료"),
    ;

    private final String value;
    private final String title;

    private MainOption(String value, String title) {
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
