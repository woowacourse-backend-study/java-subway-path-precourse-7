package subway.domain;

public class Time {
    private String departure;
    private String arrival;
    private int minute;

    public Time(String departure, String arrival, int minute) {
        this.departure = departure;
        this.arrival = arrival;
        this.minute = minute;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }
}
