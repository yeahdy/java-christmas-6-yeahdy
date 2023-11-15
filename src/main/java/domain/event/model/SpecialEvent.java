package domain.event.model;

import domain.date.AnniversaryDate;
import domain.date.DayType;
import java.time.LocalDate;

public class SpecialEvent {

    public int selectDiscountPrice(DayType dayType, LocalDate reservationFullDate) {
        if (DayType.SUNDAY.equals(dayType) || AnniversaryDate.isAnniversaryDay(reservationFullDate)) {
            return 1000;
        }
        return 0;
    }

}
