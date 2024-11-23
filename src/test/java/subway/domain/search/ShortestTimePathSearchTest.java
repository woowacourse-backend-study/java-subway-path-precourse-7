package subway.domain.search;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import subway.controller.SubwayInitializer;

public class ShortestTimePathSearchTest {

    @Test
    void 최단_거리_경로_찾기() {
        SubwayInitializer.INITIALIZER.initialize();

        ShortestTimePathSearch shortestTimePathSearch = new ShortestTimePathSearch();
        assertThat(shortestTimePathSearch.search("교대역", "양재역"))
                .containsExactly("교대역", "남부터미널역", "양재역");
    }
}
