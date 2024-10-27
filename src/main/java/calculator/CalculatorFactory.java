package calculator;

import java.util.Optional;

public class CalculatorFactory {

    public Calculator getCalculator(String rawExpression) {
        SeparatorExtractor extractor = new SeparatorExtractor();
        SeparatorExtractor.ExtractResult extracted = extractor.extract(rawExpression);

        String expression = extracted.getExpression();
        Optional<Character> separatorOptional = extracted.getSeparator();

        if (separatorOptional.isPresent()) {
            char separator = separatorOptional.get();
            return new Calculator(expression, separator);
        }
        return new Calculator(expression);
    }
}
