package calculator.view;

public class OutputView {

    public static void print(Number number) {
        if (number.doubleValue() % 1 != 0) {
            System.out.printf("결과 : %.1f", number.doubleValue());
            return;
        }

        System.out.printf("결과 : %d", number.longValue());
    }
}
