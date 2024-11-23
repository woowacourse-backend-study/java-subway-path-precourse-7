package subway.enums;

import static subway.enums.ExceptionMessage.INVALID_ANSWER;

public enum SubMenuAnswers {

    SHORTEST_DISTANCE_OPTION("1"),
    SHORTEST_TIME_OPTION("2"),
    GO_BACK_OPTION("B");

    private final String message;

    SubMenuAnswers(final String message) {
        this.message = message;
    }

    public static void checkAnswer(String answer) {
        if (!answer.equals(SHORTEST_DISTANCE_OPTION.message) && !answer.equals(SHORTEST_TIME_OPTION.message)
                && !answer.equals(GO_BACK_OPTION.message)) {
            throw new IllegalArgumentException(INVALID_ANSWER.valueOf());
        }
    }
}
