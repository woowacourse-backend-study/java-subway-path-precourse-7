package subway.controller;

import subway.enums.MainAnswers;

public class MainController implements Controller {

    private static final String EXIT = "Q";

    public MainController() {
    }

    public void startMain() {
        initializeSubway();
        entranceMain();
    }

    private void entranceMain() {
        String mainAnswer;
        while (true) {
            mainAnswer = answerInMain();
            if (mainAnswer.equals(EXIT)) {
                break;
            }
            entranceSubMenu();
        }
    }

    public void entranceSubMenu() {
        SubMenuController subMenuController = new SubMenuController();
        subMenuController.startSubMenu();
    }

    private void initializeSubway() {
        SubwayInitializer.INITIALIZER.initialize();
    }

    private String answerInMain() {
        String mainAnswer = null;
        while (mainAnswer == null) {
            try {
                outputView.showMainDisplay();
                mainAnswer = MainAnswers.checkAnswer(inputView.inputFeature());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return mainAnswer;
    }
}
