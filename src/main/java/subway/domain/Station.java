package subway.domain;

public class Station {
    private final StationName name;
    private final ConnectionStations connectionStations;

    public Station(StationName name, ConnectionStations connectionStations) {
        this.name = name;
        this.connectionStations = connectionStations;
    }

    public static Station from(StationName name, ConnectionStations connectionStations) {
        return new Station(name, connectionStations);
    }

    public String getName() {
        return name.getStationName();
    }


    // 추가 기능 구현
}
