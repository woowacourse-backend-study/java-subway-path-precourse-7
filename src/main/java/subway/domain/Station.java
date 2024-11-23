package subway.domain;

import java.util.List;
import java.util.Objects;

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

    public ConnectionStations getConnectionStations() {
        return connectionStations;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name.toString();
    }
}
