package subway.domain;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override // 디버깅
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                '}';
    }

    // 추가 기능 구현
}
