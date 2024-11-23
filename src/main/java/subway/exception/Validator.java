package subway.exception;

import static subway.enums.ExceptionMessage.EQUAL_DEPARTURE_AND_ARRIVAL;

public class Validator {

    public void validateStationAnswer(String departure, String arrival) {
        if (departure.equals(arrival)) {
            throw new IllegalArgumentException(EQUAL_DEPARTURE_AND_ARRIVAL.valueOf());
        }
    }
}
