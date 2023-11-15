package domain.event.model;

import domain.date.DayType;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import java.time.LocalDate;
import java.util.List;

public class EventFacade {

    private ChristmasEvent christmasEvent = new ChristmasEvent();
    private WeekdayEvent weekdayEvent = new WeekdayEvent();
    private WeekendEvent weekendEvent = new WeekendEvent();
    private SpecialEvent specialEvent = new SpecialEvent();
    private GiftEvent giftEvent = new GiftEvent();

    public EventDiscount getTotalEventDiscount(ReservationDate reservationDate, List<ReservationMenu> menuList,
                                               int priceBeforeDiscount) {
        int christmasPrice = getChristmasEventDiscountPrice(reservationDate.getReservedDate());
        int weekdayPrice = getWeekdayEventDiscountPrice(reservationDate.getDay(), menuList);
        int weekendPrice = getWeekendEventDiscountPrice(reservationDate.getDay(), menuList);
        int specialPrice = getSpecialEventDiscountPrice(reservationDate.getDay(),
                reservationDate.getReservationFullDate());
        int giftPrice = getGiftEventDiscountPrice(priceBeforeDiscount);

        return new EventDiscount(christmasPrice, weekdayPrice, weekendPrice, specialPrice, giftPrice);
    }

    private int getChristmasEventDiscountPrice(int reservedDate) {
        return christmasEvent.selectDiscountPrice(reservedDate);
    }

    private int getWeekdayEventDiscountPrice(DayType dayType, List<ReservationMenu> menuList) {
        return weekdayEvent.selectDiscountPrice(dayType, menuList);
    }

    private int getWeekendEventDiscountPrice(DayType dayType, List<ReservationMenu> menuList) {
        return weekendEvent.selectDiscountPrice(dayType, menuList);
    }

    private int getSpecialEventDiscountPrice(DayType dayType, LocalDate reservationFullDate) {
        return specialEvent.selectDiscountPrice(dayType, reservationFullDate);
    }

    private int getGiftEventDiscountPrice(int priceBeforeDiscount) {
        return giftEvent.selectDiscountPrice(priceBeforeDiscount);
    }

}
