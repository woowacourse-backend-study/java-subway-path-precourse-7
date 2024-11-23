package subway;

import subway.controller.SubwayController;
import subway.infrastructure.AppConfig;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        // TODO: 프로그램 구현
        AppConfig appConfig = new AppConfig();
        SubwayController controller = appConfig.controller();
        controller.run();
    }
}
