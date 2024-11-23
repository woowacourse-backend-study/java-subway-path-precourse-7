package subway.domain.vo;

public record Edge(Station station1, Station station2, int distance, int time) {
    public Edge {
        validateDistance(distance);
        validateTime(time);
    }

    private void validateDistance(int distance) {
        if (distance < 0) {
            throw new RuntimeException("거리는 0 미만으로 설정할 수 없습니다.");
        }
        if (distance > 1000) {
            throw new RuntimeException("1000km가 넘는 거리는 설정할 수 없습니다.");
        }
    }

    private void validateTime(int time) {
        if (time < 0) {
            throw new RuntimeException("시간은 음수가 될 수 없습니다.");
        }
        if (time > 100_000_000) {
            throw new RuntimeException("시간은 최대 100,000,000분까지 가능합니다.");
        }
    }
}
