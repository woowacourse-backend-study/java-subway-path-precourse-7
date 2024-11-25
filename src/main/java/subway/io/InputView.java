package subway.io;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private Scanner scanner;
    private Validate validate;

    public InputView(Scanner scanner, Validate validate) {
        this.scanner = scanner;
        this.validate = validate;
    }

    public String inputMain() {
        System.out.println("""
                ## 메인 화면
                1. 경로 조회
                Q. 종료
                """);
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();
        System.out.println();
        if (!validate.validateInputMain(input)) {
            System.out.println("[ERROR] 옳지 못한 입력입니다.");
            return inputMain();
        }
        return input;
    }

    public List<String> inputStations() {
        System.out.println("## 출발역을 입력하세요.");
        String sourceName = scanner.nextLine();
        System.out.println("## 도착역을 입력하세요.");
        String destinationName = scanner.nextLine();
        if (!validate.validateInputStations(sourceName, destinationName)) {
            System.out.println("[ERROR] 출발역과 도착역이 동일합니다.");
            return inputStations();
        }
        return List.of(sourceName, destinationName);
    }

    public String inputPolicy() {
        System.out.println("""
                ## 경로 기준
                1. 최단 거리
                2. 최소 시간
                B. 돌아가기""");
        String policyInput = scanner.nextLine();
        if (!validate.validateInputPolicy(policyInput)) {
            System.out.println("[ERROR] 옳지 못한 입력입니다.");
            return inputPolicy();
        }

        if (policyInput.equals("B")) {
            return "back";
        }
        return policyInput;
    }
}
