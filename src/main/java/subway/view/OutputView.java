package subway.view;

public class OutputView {
    private final String MAIN_PROMPT = "## 메인 화면";
    private final String SEARCH_ROUTE = "1. 경로 조회";
    private final String TERMINATION = "Q. 종료";
    private final String USER_FUNCTION_INPUT_PROMPT = "## 원하는 기능을 선택하세요.";

    public void printMainPrompt() {
        System.out.println(MAIN_PROMPT);
        System.out.println(SEARCH_ROUTE);
        System.out.println(TERMINATION);
        System.out.println();
    }

    public void printUserFunctionInputPrompt() {
        System.out.println(USER_FUNCTION_INPUT_PROMPT);
    }
}
