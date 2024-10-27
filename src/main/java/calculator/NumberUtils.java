package calculator;

public class NumberUtils {

    private NumberUtils() {
    }

    public static boolean isNumeric(char c) {
        return Character.isDigit(c);
    }
}
