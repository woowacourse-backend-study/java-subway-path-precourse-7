package subway.view;

public class OutputView {
    public void printMainOption() {
        println();
        System.out.println("메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }

    private void println() {
        System.out.println();
    }
}
