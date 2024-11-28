package subway.infrastructure.dataset;

import subway.domain.Edge;
import subway.domain.Line;

import java.util.Arrays;
import java.util.List;

public enum LineDataset {
    LINE2(new Line("2호선", List.of(
            Edge.from("교대역", "강남역", 2, 3),
            Edge.from("강남역", "역삼역", 2, 3)
    ))),
    LINE3(new Line("3호선", List.of(
            Edge.from("교대역", "남부터미널역", 3, 2),
            Edge.from("남부터미널역", "양재역", 6, 5),
            Edge.from("양재역", "매봉역", 1, 1)
    ))),
    LINE신분당(new Line("신분당선", List.of(
            Edge.from("강남역", "양재역", 2, 8),
            Edge.from("양재역", "양재시민의숲역", 10, 3)
    )))
    ;

    private final Line line;

    private LineDataset(Line line) {
        this.line = line;
    }

    public Line getData() {
        return line;
    }

    public static List<Line> getLines() {
        return Arrays.stream(values())
                .map(LineDataset::getData)
                .toList();
    }
}
