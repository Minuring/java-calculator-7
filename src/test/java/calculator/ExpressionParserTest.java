package calculator;

import static calculator.ExpressionParser.parse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ExpressionParserTest {

    @ParameterizedTest
    @CsvSource(value = {"1,1", "1.5,1.5"})
    void 구분자가_존재하지_않는경우_숫자추출(String expression, double expected) {
        List<Number> numbers = parse(expression);
        assertThat(numbers).containsExactly(expected);
    }

    @ParameterizedTest
    @MethodSource("provideNumbersWithDefaultSeparators")
    void 기본_구분자만_존재할때_숫자추출(String expression, int expectedNumberCount) {
        List<Number> numbers = parse(expression);
        assertThat(numbers).hasSize(expectedNumberCount);
    }

    private static Stream<Arguments> provideNumbersWithDefaultSeparators() {
        return Stream.of(
            Arguments.of("1,2", 2),
            Arguments.of("1.5,2.5", 2),
            Arguments.of("1.5:2.5", 2),
            Arguments.of("1,2:3", 3),
            Arguments.of("1.5,2.5:3.5", 3)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-1.1", "1,-2", "1:-2", "1,2:-3"})
    void 음수가_추출되면_예외가_발생한다(String expression) {
        assertThatThrownBy(() -> parse(expression))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("음수는 입력할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "\t", "\b", "\n"})
    void 수식에_공백이_있으면_예외가_발생한다(String blankExp) {
        assertThatThrownBy(() -> parse(blankExp))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("수식에 공백이 있습니다.");
    }
}
