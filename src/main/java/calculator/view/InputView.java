package calculator.view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.platform.commons.util.StringUtils;

public class InputView {

    public static String read() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("공백을 입력할 수 없습니다.");
        }

        return input;
    }
}
