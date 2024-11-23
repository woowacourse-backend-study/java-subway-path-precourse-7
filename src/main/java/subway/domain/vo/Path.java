package subway.domain.vo;

import subway.repository.EdgeRepository;

import java.util.List;

public class Path {
    private final List<Station> path;

    public Path(List<Station> path) {
        this.path = path;
    }

    public int getDistance() {
        int result = 0;
        for (int i = 0; i < path.size()-1; ++i) {
            Station station1 = path.get(i);
            Station station2 = path.get(i+1);
            result += EdgeRepository.getDistanceByStations(station1, station2);
        }
        return result;
    }

    public int getTime() {
        int result = 0;
        for (int i = 0; i < path.size()-1; ++i) {
            Station station1 = path.get(i);
            Station station2 = path.get(i+1);
            result += EdgeRepository.getTimeByStations(station1, station2);
        }
        return result;
    }

    public String getDistanceInfo() {
        return String.format("총 거리: %,dkm", getDistance());
    }

    public String getTimeInfo() {
        return String.format("총 소요 시간: %,d분", getTime());
    }

    public List<String> getPathInfo() {
        return path.stream().map(Station::getName).toList();
    }
}
