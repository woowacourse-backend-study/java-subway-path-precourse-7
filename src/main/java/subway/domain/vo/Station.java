package subway.domain.vo;

public class Station {
    private String name;

    public Station(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    @Override
    public boolean equals(Object o) {
        if (o instanceof Station) {
            return ((Station) o).getName().equals(name);
        }
        if (o instanceof String) {
            return o.equals(name);
        }
        return false;
    }
}
