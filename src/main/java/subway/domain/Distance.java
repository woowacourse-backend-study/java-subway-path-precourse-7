package subway.domain;

public class Distance {
    private final int distance;

    private Distance(int distance) {
        this.distance = distance;
    }

    public static Distance valueOf(String distance) {
        return new Distance(Integer.parseInt(distance));
    }
}
