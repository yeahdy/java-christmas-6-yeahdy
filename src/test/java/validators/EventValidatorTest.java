package validators;

import constants.ErrorCodeConstant;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class EventValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {" ","","가나","23가나다","!@"})
    @DisplayName("잘못된 날짜 입력 시 예외 메세지 검증")
    void verify_date_error_message_test(final String characters) {
        //when
        Throwable thrown = Assertions.catchThrowable(() -> {
            EventValidator.validateNumber(characters);
        });

        // then
        Assertions.assertThat(thrown)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCodeConstant.NOT_VALID_DATE_ERROR);
    }

}
