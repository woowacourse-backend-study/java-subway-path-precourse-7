package subway.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputFeature() {
        System.out.println("## 원하는 기능을 선택하세요.");
        return Console.readLine();
    }

    public String inputDepartureStation() {
        System.out.println("## 출발역을 입력하세요.");
        return Console.readLine();
    }

    public String inputArrivalStation() {
        System.out.println("## 도착역을 입력하세요.");
        return Console.readLine();
    }
}
