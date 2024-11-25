package subway.dto;

import subway.service.PathStandard;

public record PathRequestDto(PathStandard pathStandard, String startStation, String endStation) {
}
