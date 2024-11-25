package subway.domain;

public class Track {

    private String destinationName;

    private int distance;

    private int price;

    public Track(String destinationName, int distance, int price) {
        this.destinationName = destinationName;
        this.distance = distance;
        this.price = price;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public int getDistance() {
        return distance;
    }

    public int getPrice() {
        return price;
    }
}
