package subway.domain;

public class Distance {
    private String departure;
    private String arrival;
    private int kilometer;

    public Distance(String departure, String arrival, int kilometer) {
        this.departure = departure;
        this.arrival = arrival;
        this.kilometer = kilometer;
    }

    public String getDeparture() {
        return departure;
    }

    public String getArrival() {
        return arrival;
    }
}
