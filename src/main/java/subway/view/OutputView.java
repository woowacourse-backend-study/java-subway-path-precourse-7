package subway.view;

public class OutputView {
    public void printMainOption() {
        println();
        System.out.println("메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }

    public void printServiceOption() {
        println();
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
    }

    public void printErrorMessage(String message) {
        System.out.println(message);
    }

    private void println() {
        System.out.println();
    }
}
