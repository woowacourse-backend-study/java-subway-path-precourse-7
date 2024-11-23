package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConnectionStations {

    private final List<ConnectionStationInfo> connectionStationInfos;

    private ConnectionStations(List<ConnectionStationInfo> connectionStationInfos) {
        this.connectionStationInfos =  connectionStationInfos;
    }

    public static ConnectionStations newInstance(ConnectionStationInfo... connectionStationInfos) {
        List<ConnectionStationInfo> connections = Arrays.stream(connectionStationInfos).toList();
        return new ConnectionStations(connections);
    }

    public void addConnections(String name, String distance, String time) {
        ConnectionStationInfo connectionInfo = ConnectionStationInfo.from(name, distance, time);
        connectionStationInfos.add(connectionInfo);
    }

}
