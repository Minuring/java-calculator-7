package calculator.view;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputViewTest extends IOTest {

    @Test
    void 덧셈할_문자열_입력() {
        systemIn("1,2:3");

        String input = InputView.read();

        assertThat(systemOutput()).contains("덧셈할 문자열을 입력해 주세요.");
        assertThat(input).isEqualTo("1,2:3");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\r", "\t", "\b", "\n"})
    void 문자열이_비었으면_오류발생(String command) {
        systemIn(command);
        assertThatThrownBy(InputView::read)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("공백을 입력할 수 없습니다.");
    }
}
