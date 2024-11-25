package calculator;

import static calculator.ExpressionParser.parse;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CustomSeparatorTest {

    @Test
    void 커스텀_구분자를_포함해_구분할수있다() {
        List<Number> numbers = parse("//@\n1@2@3");
        assertThat(numbers).containsExactly(1.0, 2.0, 3.0);
    }

    @Test
    void 커스텀_구분자를_여러개_등록할수_있다() {
        List<Number> numbers = parse("//@#\n1@2#3");
        assertThat(numbers).containsExactly(1.0, 2.0, 3.0);
    }

    @Test
    void 기본_구분자가_손실되지_않는다() {
        List<Number> numbers = parse("//@#\n1,2:3@4#5");
        assertThat(numbers).containsExactly(1.0, 2.0, 3.0, 4.0, 5.0);
    }
}
