package subway.service.dto;

import subway.domain.Path;

public record PathResult(Path path, int distance, int time) {
}
