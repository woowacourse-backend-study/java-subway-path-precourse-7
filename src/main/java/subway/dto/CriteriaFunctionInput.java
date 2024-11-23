package subway.dto;

public class CriteriaFunctionInput {
    private final String input;

    private CriteriaFunctionInput(String input) {
        this.input = input;
    }

    public static CriteriaFunctionInput from(String input) {
        return new CriteriaFunctionInput(input);
    }

    public String getInput() {
        return input;
    }
}
