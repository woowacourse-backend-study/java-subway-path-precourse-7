package subway.domain;

import java.util.Arrays;

public enum MainOption {

    FIND_ROUTE("1"),
    EXIT("Q");

    private final String option;

    MainOption(String option) {
        this.option = option;
    }

    public boolean isPlayable() {
        return this != EXIT;
    }

    public static MainOption from(String input) {
        return Arrays.stream(MainOption.values())
                .filter(option -> option.getOption().equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[Error] 선택할 수 없는 기능입니다."));
    }

    public String getOption() {
        return option;
    }
}
