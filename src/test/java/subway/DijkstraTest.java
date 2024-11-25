package subway;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import subway.domain.Dijkstra;
import subway.domain.Path;
import subway.domain.PathPolicy;
import subway.domain.Policy;
import subway.domain.Station;
import subway.domain.StationRepository;

public class DijkstraTest {

    @BeforeAll
    static void beforeAll() {

    }

    @Test
    void 다익스트라_테스트() {
        //given
        Factory.init();
        String sourceName = "교대역";
        Station sourceStation = StationRepository.findByName(sourceName);
        PathPolicy pathPolicy = new PathPolicy(Policy.SHORT_DISTANCE);
        Dijkstra dijkstra = new Dijkstra(sourceStation, pathPolicy);

        //when
        dijkstra.calculatePath();
        String destinationName = "양재역";
        Path shortestPath = dijkstra.getShortestPath(destinationName);

        //then
        System.out.println(shortestPath);

    }
}
