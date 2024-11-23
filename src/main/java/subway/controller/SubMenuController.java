package subway.controller;

import subway.enums.SubMenuAnswers;

public class SubMenuController implements Controller {

    private static final String SHORTEST_DISTANCE_OPTION = "1";
    private static final String SHORTEST_TIME_OPTION = "2";
    private static final String GO_BACK_OPTION = "B";

    private final MainController mainController;
    private final SubwayPathController subwayPathController;

    public SubMenuController() {
        this.mainController = new MainController();
        this.subwayPathController = new SubwayPathController(this);
    }

    public void startSubMenu() {

        while (true) {
            String subMenuAnswer = answerInSubMenu();
            if (subMenuAnswer.equals(GO_BACK_OPTION)) {
                mainController.startMain();
            }
            if (subMenuAnswer.equals(SHORTEST_DISTANCE_OPTION) || subMenuAnswer.equals(SHORTEST_TIME_OPTION)) {
                subwayPathController.startFindPath(subMenuAnswer);
                break;
            }
        }
    }

    private String answerInSubMenu() {
        String subMenuAnswer = null;
        while (subMenuAnswer == null) {
            try {
                outputView.showPathStandardSelectDisplay();
                subMenuAnswer = SubMenuAnswers.checkAnswer(inputView.inputFeature());
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
            }
        }
        return subMenuAnswer;
    }
}
