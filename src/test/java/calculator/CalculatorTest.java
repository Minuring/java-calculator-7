package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void 계산기_테스트() {
        double result = Calculator.sum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 실수계산_테스트() {
        double result = Calculator.sum("1.1,2.2,3.3");
        assertThat(result).isEqualTo(6.6);
    }

    @Test
    void 정수_실수_혼합_테스트() {
        double result = Calculator.sum("//@#\\n1,2.2:3.3@4#5.5");
        assertThat(result).isEqualTo(16);
    }
}
