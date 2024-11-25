package calculator;

import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {

    public static void main(String[] args) {
        String input = InputView.read();
        double result = Calculator.sum(input);
        OutputView.print(result);
    }
}
