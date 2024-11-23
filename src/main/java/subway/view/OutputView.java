package subway.view;

public class OutputView {
    private final String MAIN_PROMPT = "## 메인 화면";
    private final String SEARCH_ROUTE = "1. 경로 조회";
    private final String TERMINATION = "Q. 종료";

    public void printMainPrompt() {
        System.out.println(MAIN_PROMPT);
        System.out.println(SEARCH_ROUTE);
        System.out.println(TERMINATION);
        System.out.println();
    }
}
