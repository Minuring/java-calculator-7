package calculator;

public class Calculator {

    private static final String DEFAULT_SEPARATORS = ",:";

    private final String exp;
    private final String regex;

    public Calculator(String expression) {
        this.regex = "[" + DEFAULT_SEPARATORS + "]";
        this.exp = expression;
    }

    public Calculator(String expression, char customSeparator) {
        this.regex = "[" + DEFAULT_SEPARATORS + customSeparator + "]";
        this.exp = expression;
    }

    public int calculate() {
        String[] parts = exp.split(regex);
        int result = 0;

        for (String part : parts) {
            if (part.isBlank()) {
                continue;
            }

            try {
                int n = Integer.parseInt(part);
                if (n < 0) {
                    throw new IllegalArgumentException();
                }

                result += n;
            } catch (NumberFormatException expected) {
                throw new IllegalArgumentException();
            }
        }
        return result;
    }

    public String getExp() {
        return exp;
    }

    public String getRegex() {
        return regex;
    }
}