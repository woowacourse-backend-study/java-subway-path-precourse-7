package subway.service;

import subway.domain.vo.Station;
import subway.infrastructure.ErrorException;
import subway.repository.StationRepository;

public class InputValidator {
    public void validateStation(String station) {
        if (station.trim().isEmpty()) {
            throw new ErrorException("빈 문자열은 역 이름으로 입력할 수 없습니다.");
        }
        Station found = StationRepository.findByName(station.trim());
        if (found == null) {
            throw new ErrorException(String.format("%s는 존재하지 않는 역입니다.", station));
        }
    }

    public void validateStations(String start, String dest) {
        if (start.trim().equals(dest.trim())) {
            throw new ErrorException("출발역과 도착역이 동일합니다.");
        }
    }
}
