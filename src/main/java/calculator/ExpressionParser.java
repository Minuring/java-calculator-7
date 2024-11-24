package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExpressionParser {

    private static final String REGEX_BLANK_FILTER = "[ \\s\\n\\t\b]?";
    private static final String REGEX_DEFAULT_SEPARATOR = "[,:]";

    public static List<Number> parse(String rawExpression) {
        validateBlankNotExists(rawExpression);
        return extractNumbers(rawExpression);
    }

    private static List<Number> extractNumbers(String rawExpression) {
        String[] rawNumbers = rawExpression.split(REGEX_DEFAULT_SEPARATOR);

        List<Number> numbers = new ArrayList<>();
        Arrays.stream(rawNumbers)
            .map(Double::parseDouble)
            .peek(ExpressionParser::validateNegativeNumberNotExists)
            .forEach(numbers::add);

        return numbers;
    }

    private static void validateNegativeNumberNotExists(Number number) {
        if (number.doubleValue() < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
    }

    private static void validateBlankNotExists(String rawExpression) {
        if (rawExpression == null || hasAnyBlank(rawExpression)) {
            throw new IllegalArgumentException("수식에 공백이 있습니다.");
        }
    }

    private static boolean hasAnyBlank(String expression) {
        return expression.matches(REGEX_BLANK_FILTER);
    }
}
