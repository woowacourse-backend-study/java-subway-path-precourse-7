package subway.domain;

import static subway.enums.ExceptionMessage.EQUAL_DEPARTURE_AND_ARRIVAL;

import java.util.Objects;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void checkSameName(String arrival) {
        if (this.name.equals(arrival)) {
            throw new IllegalArgumentException(EQUAL_DEPARTURE_AND_ARRIVAL.valueOf());
        }
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Station station)) {
            return false;
        }
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
