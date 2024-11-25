package calculator;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparatorExtractor {

    private static final String DEFAULT_SEPARATORS = ",:";
    private static final Pattern CUSTOM_SEPARATOR_PATTERN = Pattern.compile("//(\\D+)\\\\n");
    private static final int CUSTOM_SEPARATOR_INDEX = 1;

    public static Pattern extractSeparatorsPattern(String expression) {
        StringBuilder regex = new StringBuilder(DEFAULT_SEPARATORS);

        findCustomSeparators(expression).forEach(regex::append);

        return Pattern.compile("[" + regex + "]");
    }

    public static String removeCustomSeparatorRegisterPrefix(String expression) {
        return CUSTOM_SEPARATOR_PATTERN.matcher(expression).replaceAll("");
    }

    private static List<Character> findCustomSeparators(String expression) {
        Matcher matcher = CUSTOM_SEPARATOR_PATTERN.matcher(expression);
        if (!matcher.find()) {
            return Collections.emptyList();
        }

        return matcher.group(CUSTOM_SEPARATOR_INDEX).chars()
            .mapToObj(i -> (char) i)
            .toList();
    }
}
