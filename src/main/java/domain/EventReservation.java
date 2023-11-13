package domain;

import java.time.LocalDate;
import java.util.HashMap;
import utils.DateUtils;
import validators.ReservationDateValidator;

public class EventReservation {

    private LocalDate reservationDate;  //예약날짜
    private DayType day; //요일
    private HashMap<Menu,Integer> menuList;

    public EventReservation (int number){
        ReservationDateValidator.validateBetweenDate(number);

        this.reservationDate = createReservationDate(number);
        this.day = createDay(this.reservationDate);
    }

    private LocalDate createReservationDate(int number){
        return DateUtils.getLocalDateByNumber(number);
    }

    private DayType createDay(LocalDate reservationDate){
        DayType dayType = AnniversaryDate.getAnniversaryDayType(reservationDate);;
        if(dayType != null){
            return dayType;
        }

        return DayType.getDayTypeByLocalDate(reservationDate);
    }

}
