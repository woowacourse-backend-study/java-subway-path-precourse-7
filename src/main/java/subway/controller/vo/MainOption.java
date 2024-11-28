package subway.controller.vo;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

    public static Optional<MainOption> from(String input) {
        return Arrays.stream(values())
                .filter(v -> v.value.equals(input))
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
                .map(MainOption::getTitle)
                .toList();
    }
}
