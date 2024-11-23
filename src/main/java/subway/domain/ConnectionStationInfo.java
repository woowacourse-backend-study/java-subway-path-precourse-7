package subway.domain;

public class ConnectionStationInfo {

    private final StationName stationName;
    private final Distance distance;
    private final Time time;

    private ConnectionStationInfo(StationName stationName, Distance distance, Time time) {
        this.stationName = stationName;
        this.distance = distance;
        this.time = time;
    }

    public static ConnectionStationInfo from(String name, String distance, String time) {
        return new ConnectionStationInfo(
                StationName.valueOf(name),
                Distance.valueOf(distance),
                Time.valueOf(time)
        );
    }

    public String getStationName() {
        return stationName.getStationName();
    }

    public int getDistance() {
        return distance.getDistance();
    }

    public int getTime() {
        return time.getTime();
    }

    @Override
    public String toString() {
        return "ConnectionStationInfo{" +
                "stationName=" + stationName +
                ", distance=" + distance +
                ", time=" + time +
                '}';
    }
}
