package domain;

import constants.DayType;
import java.time.LocalDate;
import java.util.HashMap;
import utils.DateUtils;
import validators.EventValidator;

public class EventReservation {

    private LocalDate reservationDate;  //예약날짜
    private DayType day; //요일
    private HashMap<Menu,Integer> menuList;

    public EventReservation (int number){
        EventValidator.validateBetweenDate(number);

        this.reservationDate = createReservationDate(number);
        this.day = createDay(this.reservationDate);
    }

    private LocalDate createReservationDate(int number){
        return DateUtils.getLocalDateByNumber(number);
    }

    private DayType createDay(LocalDate reservationDate){
        String day = DateUtils.getDayByLocalDate(reservationDate);
        return DayType.getDayTypeByString(day);
    }

}
