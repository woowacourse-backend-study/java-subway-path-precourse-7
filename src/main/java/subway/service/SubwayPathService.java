package subway.service;

import java.util.List;
import java.util.stream.Collectors;
import subway.domain.Section;
import subway.domain.Station;
import subway.domain.path.PathResult;
import subway.domain.path.ShortestDistancePath;
import subway.domain.path.ShortestPath;
import subway.domain.path.ShortestTimePath;
import subway.dto.PathRequestDto;
import subway.dto.PathResponseDto;
import subway.repository.SectionRepository;
import subway.repository.StationRepository;

public class SubwayPathService {
    private final ShortestPath shortestDistancePath;
    private final ShortestPath shortestTimePath;

    public SubwayPathService() {
        List<Station> stations = StationRepository.stations();
        List<Section> sections = SectionRepository.sections();
        this.shortestDistancePath = new ShortestDistancePath(stations, sections);
        this.shortestTimePath = new ShortestTimePath(stations, sections);
    }

    public PathResponseDto getShortestPath(PathRequestDto pathRequestDto) {
        PathStandard pathStandard = pathRequestDto.pathStandard();
        Station startStation = StationRepository.findByName(pathRequestDto.startStation());
        Station endStation = StationRepository.findByName(pathRequestDto.endStation());
        if (pathStandard.isDistance()) {
            return calculateDistancePath(startStation, endStation);
        }
        if (pathStandard.isTime()) {
            return calculateTimePath(startStation, endStation);
        }
        throw new IllegalStateException();
    }

    private PathResponseDto calculateDistancePath(Station startStation, Station endStation) {
        PathResult pathResult = shortestDistancePath.calculatePath(startStation, endStation);
        List<String> stationsNames = mapToName(pathResult.getStations());
        return new PathResponseDto(pathResult.getWeight(), calculateTime(pathResult), stationsNames);
    }

    private PathResponseDto calculateTimePath(Station startStation, Station endStation) {
        PathResult pathResult = shortestTimePath.calculatePath(startStation, endStation);
        List<String> stationsNames = mapToName(pathResult.getStations());
        return new PathResponseDto(calculateDistance(pathResult), pathResult.getWeight(), stationsNames);
    }

    private int calculateTime(PathResult pathResult) {
        List<List<String>> edgeStationNames = pathResult.getEdgeStationNames();
        List<Section> sections = SectionRepository.findByEdgeStationNames(edgeStationNames);
        return calculateTimeSum(sections);
    }

    private int calculateTimeSum(List<Section> sections) {
        return sections.stream()
                .mapToInt(Section::getTime)
                .sum();
    }

    private int calculateDistance(PathResult pathResult) {
        List<List<String>> edgeStationNames = pathResult.getEdgeStationNames();
        List<Section> sections = SectionRepository.findByEdgeStationNames(edgeStationNames);
        return calculateDistanceSum(sections);
    }

    private int calculateDistanceSum(List<Section> sections) {
        return sections.stream()
                .mapToInt(Section::getDistance)
                .sum();
    }

    private List<String> mapToName(List<Station> stations) {
        return stations.stream()
                .map(Station::getName)
                .collect(Collectors.toList());
    }
}