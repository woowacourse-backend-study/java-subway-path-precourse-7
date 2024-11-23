package subway.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import subway.domain.vo.Edge;
import subway.domain.vo.Path;
import subway.domain.vo.Station;
import subway.repository.EdgeRepository;
import subway.repository.StationRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PathServiceTest {
    private final PathService pathService = new PathService();

    List<Edge> edges = List.of(
            new Edge(new Station("교대역"), new Station("강남역"), 2, 3),
            new Edge(new Station("강남역"), new Station("역삼역"), 2, 3),
            new Edge(new Station("교대역"), new Station("남부터미널역"), 3, 2),
            new Edge(new Station("남부터미널역"), new Station("양재역"), 6, 5),
            new Edge(new Station("강남역"), new Station("양재역"), 2, 8),
            new Edge(new Station("양재역"), new Station("매봉역"), 1, 1),
            new Edge(new Station("양재역"), new Station("양재시민의숲역"), 10, 3)
    );

    List<Station> stations = List.of(
            new Station("교대역"),
            new Station("강남역"),
            new Station("역삼역"),
            new Station("남부터미널역"),
            new Station("양재역"),
            new Station("매봉역"),
            new Station("양재시민의숲역")
    );

    @BeforeEach
    void setup() {
        EdgeRepository.deleteAll();
        StationRepository.deleteAll();
        EdgeRepository.addAll(edges);
        StationRepository.addAll(stations);
    }

    @Test
    @DisplayName("최소 시간으로 경로를 찾을 수 있다.")
    void 최소시간_경로() {
        // given
        String start = "교대역";
        String dest = "양재역";

        // when
        Path timePath = pathService.getTimePath(start, dest);

        // then
        assertThat(timePath.getTime()).isEqualTo(7);
        assertThat(timePath.getDistance()).isEqualTo(9);
    }

    @Test
    @DisplayName("최소 거리로 경로를 찾을 수 있다.")
    void 최단거리_경로() {
        // given
        String start = "교대역";
        String dest = "양재역";

        // when
        Path timePath = pathService.getDistancePath(start, dest);

        // then
        assertThat(timePath.getTime()).isEqualTo(11);
        assertThat(timePath.getDistance()).isEqualTo(4);
    }
}