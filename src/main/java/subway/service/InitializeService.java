package subway.service;

import subway.domain.vo.Edge;
import subway.domain.vo.Line;
import subway.repository.EdgeRepository;
import subway.repository.LineRepository;
import subway.domain.vo.Station;
import subway.repository.StationRepository;

import java.util.List;

public class InitializeService {

    public void init() {
        initLines();
        initStations();
        initEdges();
    }

    private void initLines() {
        List<Line> lines = List.of(
                new Line("2호선"),
                new Line("3호선"),
                new Line("신분당선")
        );
        LineRepository.addAll(lines);
    }

    // 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역
    private void initStations() {
        List<Station> stations = List.of(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("양재시민의숲역"),
                new Station("매봉역")
        );
        StationRepository.addAll(stations);
    }

    private void initEdges() {
        List<Edge> edges = List.of(
                new Edge(new Station("교대역"), new Station("강남역"), 2, 3),
                new Edge(new Station("강남역"), new Station("역삼역"), 2, 3),
                new Edge(new Station("교대역"), new Station("남부터미널역"), 3, 2),
                new Edge(new Station("남부터미널역"), new Station("양재역"), 6, 5),
                new Edge(new Station("강남역"), new Station("양재역"), 2, 8),
                new Edge(new Station("양재역"), new Station("매봉역"), 1, 1),
                new Edge(new Station("양재역"), new Station("양재시민의숲역"), 10, 3)
        );
        EdgeRepository.addAll(edges);
    }
}
