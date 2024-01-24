package domain.event.model;

import domain.date.AnniversaryDate;
import domain.date.DayType;
import java.time.LocalDate;

public class SpecialEvent extends Event{

    private DayType dayType;

    private final LocalDate reservationFullDate;

    public SpecialEvent(DayType dayType, LocalDate reservationFullDate) {
        this.dayType = dayType;
        this.reservationFullDate = reservationFullDate;
    }

    @Override
    public int selectDiscountPrice() {
        if (DayType.SUNDAY.equals(dayType) || AnniversaryDate.isAnniversaryDay(reservationFullDate)) {
            return 1000;
        }
        return 0;
    }

}
