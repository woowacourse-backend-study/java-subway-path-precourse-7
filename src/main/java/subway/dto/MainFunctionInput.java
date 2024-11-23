package subway.dto;

public class MainFunctionInput {
    private final String input;

    private MainFunctionInput(String input) {
        this.input = input;
    }

    public static MainFunctionInput from(String input) {
        return new MainFunctionInput(input);
    }

    public String getInput() {
        return input;
    }
}
