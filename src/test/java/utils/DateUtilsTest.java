package utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateUtilsTest {

    @DisplayName("사용자가 입력한 날짜를 입력 시 LocalDate 형식으로 변환한다")
    @Test
    void change_localDate_test() {
        //given
        int number = 25;

        //when
        LocalDate date = DateUtils.getLocalDateByNumber(number);
        LocalDate expectedDate = LocalDate.of(2023, 12, 25);

        //then
        assertThat(date).isEqualTo(expectedDate);
    }

    @DisplayName("2023년 12월25일은 MONDAY 이다.")
    @Test
    void verify_day_test() {
        //given
        LocalDate date = LocalDate.of(2023, 12, 25);

        //when
        String day = DateUtils.getDayByLocalDate(date);

        //then
        assertThat(day).isEqualTo("MONDAY");
    }

}
