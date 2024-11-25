package calculator;

import java.util.List;

public class Calculator {
    public static double sum(String expression) {
        List<Number> numbers = ExpressionParser.parse(expression);

        return numbers.stream()
            .mapToDouble(Number::doubleValue)
            .sum();
    }
}
