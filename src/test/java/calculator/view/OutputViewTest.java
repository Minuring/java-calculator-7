package calculator.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class OutputViewTest extends IOTest {

    @Test
    void 정수_출력() {
        OutputView.print(5);
        assertThat(systemOutput()).contains("결과 : 5");
    }

    @Test
    void 실수_출력() {
        OutputView.print(10.5);
        assertThat(systemOutput()).contains("결과 : 10.5");
    }
}
