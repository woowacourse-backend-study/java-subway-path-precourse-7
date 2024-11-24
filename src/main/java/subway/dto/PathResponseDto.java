package subway.dto;

import java.util.List;

public record PathResponseDto(int distance, int time, List<String> route) {
}