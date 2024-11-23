package subway.domain;

public class Section {

    private final Station left;
    private final Station right;
    private final int distance;
    private final int time;

    public Section(Station left, Station right, int distance, int time) {
        this.left = left;
        this.right = right;
        this.distance = distance;
        this.time = time;
    }
    @Override
    public String toString() {
        return "Section{" +
                "left=" + left +
                ", right=" + right +
                ", distance=" + distance +
                ", time=" + time +
                '}';
    }
}
