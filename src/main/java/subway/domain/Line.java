package subway.domain;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    @Override  // 디버깅
    public String toString() {
        return "Line{" + "name='" + name + '\'' +
                '}';
    }



    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
