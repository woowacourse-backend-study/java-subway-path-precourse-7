package subway.controller;

import subway.enums.SubMenuAnswers;

public class SubMenuController implements Controller {

    private final SubwayPathController subwayPathController;

    public SubMenuController() {
        this.subwayPathController = new SubwayPathController(new SubMenuController());
    }

    public void startSubMenu() {

        while (true) {
            String subMenuAnswer = answerInSubMenu();
            if (subMenuAnswer.equals("B")) {
                return;
            }
            if (subMenuAnswer.equals("1") || subMenuAnswer.equals("2")) {
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
