package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class ReservationDateTest {

    @ParameterizedTest
    @MethodSource("getNumberAndDayType")
    @DisplayName("이벤트 예약 날짜에 따른 요일 타입 테스트")
    void create_eventReservation_test(int number, DayType dayType) {
        //when
        ReservationDate reservationDate = new ReservationDate(number);

        //then
        assertThat(reservationDate)
                .isNotNull()
                .extracting("day")
                .isEqualTo(dayType);
    }

    private static Stream<Arguments> getNumberAndDayType() {
        return Stream.of(
                Arguments.of(18, DayType.MONDAY),
                Arguments.of(19, DayType.TUESDAY),
                Arguments.of(20, DayType.WEDNESDAY),
                Arguments.of(21, DayType.THURSDAY),
                Arguments.of(22, DayType.FRIDAY),
                Arguments.of(23, DayType.SATURDAY),
                Arguments.of(24, DayType.SUNDAY),
                Arguments.of(25, DayType.MONDAY)
        );
    }

}
