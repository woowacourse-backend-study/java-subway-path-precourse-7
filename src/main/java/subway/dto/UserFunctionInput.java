package subway.dto;

public class UserFunctionInput {
    private final String input;

    private UserFunctionInput(String input) {
        this.input = input;
    }

    public static UserFunctionInput from(String input) {
        return new UserFunctionInput(input);
    }

    public String getInput() {
        return input;
    }
}
