package subway.domain;

public class Time {
    private final int time;

    private Time(int time) {
        this.time = time;
    }

    public static Time valueOf(String time) {
        return new Time(Integer.parseInt(time));
    }
}
