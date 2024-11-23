package subway.controller;

import subway.enums.MainAnswers;

public class MainController implements Controller {

    private final SubMenuController subMenuController;

    public MainController() {
        this.subMenuController = new SubMenuController();
    }

    public void startMain() {
        initializeSubway();
        entranceMain();
    }

    private void entranceMain() {
        String mainAnswer;
        while (true) {
            mainAnswer = answerInMain();
            if (mainAnswer.equals("Q")) {
                break;
            }
            subMenuController.startSubMenu();
        }
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
