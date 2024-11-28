package subway.service;

import subway.domain.Station;
import subway.domain.StationRepository;
import subway.infrastructure.constants.ExceptionMessage;
import subway.infrastructure.exception.CustomException;

import java.util.Optional;

public class InputValidator {
    public void validateStation(String name) {
        Optional<Station> station = StationRepository.findStation(name);
        if (station.isEmpty()) {
            throw new CustomException(ExceptionMessage.NOT_EXIST_STATION.getMessage());
        }
    }

    public void validateStationDifferent(String start, String end) {
        if (start.equals(end)) {
            throw new CustomException(ExceptionMessage.SAME_STATION.getMessage());
        }
    }
}
