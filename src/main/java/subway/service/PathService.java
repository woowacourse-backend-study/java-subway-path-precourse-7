package subway.service;

import subway.domain.DistancePath;
import subway.domain.TimePath;
import subway.domain.vo.Path;
import subway.domain.vo.Station;
import subway.infrastructure.ErrorException;
import subway.repository.EdgeRepository;
import subway.repository.StationRepository;

public class PathService {
    public Path getDistancePath(String start, String dest) {
        validate(start, dest);
        DistancePath distancePath = new DistancePath(StationRepository.stations(), EdgeRepository.edges());
        Path path = distancePath.getPath(start, dest);
        if (path == null) {
            throw new ErrorException("이동할 수 없는 경로입니다.");
        }
        return path;
    }

    public Path getTimePath(String start, String dest) {
        validate(start, dest);
        TimePath timePath = new TimePath(StationRepository.stations(), EdgeRepository.edges());
        Path path = timePath.getPath(start, dest);
        if (path == null) {
            throw new ErrorException("이동할 수 없는 경로입니다.");
        }
        return path;
    }

    private void validate(String start, String dest) {
        validateStationsName(start, dest);
        Station station1 = StationRepository.findByName(start.trim());
        Station station2 = StationRepository.findByName(dest.trim());
        validateStations(station1, station2);
    }

    private void validateStationsName(String start, String dest) {
        if (start.trim().isEmpty() || dest.trim().isEmpty()) {
            throw new ErrorException("빈 문자열은 역 이름으로 입력할 수 없습니다.");
        }
        if (start.trim().equals(dest.trim())) {
            throw new ErrorException("출발역과 도착역이 동일합니다.");
        }
    }

    private void validateStations(Station station1, Station station2) {
        if (station1 == null || station2 == null) {
            throw new ErrorException("존재하지 않는 역이 포함되어 있습니다.");
        }
    }
}
