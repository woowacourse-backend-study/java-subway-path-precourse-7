package subway.dto;

public class DepartureStationInput {
    private final String input;

    private DepartureStationInput(String input) {
        this.input = input;
    }

    public static DepartureStationInput from(String input) {
        return new DepartureStationInput(input);
    }

    public String getInput() {
        return input;
    }
}
