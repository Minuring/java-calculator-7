package calculator;

public class NumberUtils {

    private NumberUtils() {
    }

    public static boolean isNumeric(char c) {
        try {
            Double.parseDouble(String.valueOf(c));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
