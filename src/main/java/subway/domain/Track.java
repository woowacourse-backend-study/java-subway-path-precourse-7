package subway.domain;

public class Track {

    private String sourceName;

    private String destinationName;

    private int distance;

    private int price;

    public Track(String sourceName, String destinationName, int distance, int price) {
        this.sourceName = sourceName;
        this.destinationName = destinationName;
        this.distance = distance;
        this.price = price;
    }

    public String getSourceName() {
        return sourceName;
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

    @Override
    public String toString() {
        return String.format("[INFO] %s\n", sourceName);
    }
}
