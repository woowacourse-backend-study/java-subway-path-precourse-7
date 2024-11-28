package subway.view;

import camp.nextstep.edu.missionutils.Console;
import subway.controller.vo.MainOption;
import subway.controller.vo.PathStandardOption;
import subway.infrastructure.constants.ExceptionMessage;
import subway.infrastructure.exception.CustomException;

import java.util.Optional;
import java.util.function.Supplier;

public class InputView {
    public MainOption readMainOption() {
        return doLoop(() -> {
            System.out.println("## 원하는 기능을 선택하세요.");
            String input = Console.readLine().trim();
            Optional<MainOption> option = MainOption.from(input);
            if (option.isEmpty()) {
                throw new CustomException(ExceptionMessage.INVALID_INPUT.getMessage());
            }
            return option.get();
        });
    }

    public PathStandardOption readPathOption() {
        return doLoop(() -> {
            System.out.println("## 원하는 기능을 선택하세요.");
            String input = Console.readLine().trim();
            Optional<PathStandardOption> option = PathStandardOption.from(input);
            if (option.isEmpty()) {
                throw new CustomException(ExceptionMessage.INVALID_INPUT.getMessage());
            }
            return option.get();
        });
    }

    public String readStartStation() {
        System.out.println("## 출발역을 입력하세요.");
        return Console.readLine().trim();
    }

    public String readDestStation() {
        System.out.println("## 도착역을 입력하세요.");
        return Console.readLine().trim();
    }

    private <T> T doLoop(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
