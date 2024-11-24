package subway.domain.path;

import subway.domain.Station;

public interface ShortestPath {
    PathResult calculatePath(Station start, Station end);
}
