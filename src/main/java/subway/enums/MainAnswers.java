package subway.enums;

import static subway.enums.ExceptionMessage.INVALID_ANSWER;

public enum MainAnswers {

    FIND_PATH_OPTION("1"),
    QUIT_OPTION("Q");

    private final String message;

    MainAnswers(final String message) {
        this.message = message;
    }

    public static void checkAnswer(String answer) {
        if (!answer.equals(FIND_PATH_OPTION.message) && !answer.equals(QUIT_OPTION.message)) {
            throw new IllegalArgumentException(INVALID_ANSWER.valueOf());
        }
    }
}
