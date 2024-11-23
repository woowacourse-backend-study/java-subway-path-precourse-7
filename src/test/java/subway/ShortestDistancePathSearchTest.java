package subway;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import subway.controller.SubwayInitializer;
import subway.domain.search.ShortestDistancePathSearch;

public class ShortestDistancePathSearchTest {

    @Test
    void 최단_거리_경로_찾기() {
        SubwayInitializer.INITIALIZER.initialize();

        ShortestDistancePathSearch shortestDistancePathSearch = new ShortestDistancePathSearch();
        assertThat(shortestDistancePathSearch.search("교대역", "양재역"))
                .containsExactly("교대역", "강남역", "양재역");
    }
}
