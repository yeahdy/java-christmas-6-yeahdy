package domain.reservation.model;

import domain.date.AnniversaryDate;
import domain.date.DayType;
import java.time.LocalDate;
import utils.DateUtils;
import validators.ReservationDateValidator;

public class ReservationDate {

    private final LocalDate reservationFullDate;  //날짜(년/월/일)
    private final int reservedDate;   //예약일
    private final DayType day; //요일

    public ReservationDate(int reservedDate){
        ReservationDateValidator.validateBetweenDate(reservedDate);

        this.reservedDate = reservedDate;
        this.reservationFullDate = createReservationFullDate(reservedDate);
        this.day = createDay(this.reservationFullDate);
    }

    private LocalDate createReservationFullDate(int reservedDate){
        return DateUtils.getLocalDateByNumber(reservedDate);
    }

    private DayType createDay(LocalDate reservationFullDate){
        DayType dayType = AnniversaryDate.getAnniversaryDayType(reservationFullDate);;
        if(dayType != null){
            return dayType;
        }

        return DayType.getDayTypeByLocalDate(reservationFullDate);
    }

}
