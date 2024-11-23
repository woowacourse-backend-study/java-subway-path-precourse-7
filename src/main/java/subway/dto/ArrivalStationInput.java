package subway.dto;

public class ArrivalStationInput {

    private final String input;

    private ArrivalStationInput(String input) {
        this.input = input;
    }

    public static ArrivalStationInput from(String input) {
        return new ArrivalStationInput(input);
    }

    public String getInput() {
        return input;
    }
}
