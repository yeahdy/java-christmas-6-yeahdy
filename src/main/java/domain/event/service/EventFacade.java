package domain.event.service;

import domain.date.DayType;
import domain.event.model.ChristmasEvent;
import domain.event.model.EventDiscount;
import domain.event.model.GiftEvent;
import domain.event.model.SpecialEvent;
import domain.event.model.WeekdayEvent;
import domain.event.model.WeekendEvent;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import java.time.LocalDate;
import java.util.List;

public class EventFacade {

    /* FIXME: Event 추상클래스 만들기, 인자 갯수/타입이 다름
        이벤트 별 할인 금액 계산하기
        누구와 협력? 이벤트 별로 협력하는 객체가 다름
        Event 객체를 생성자 주입을 통해 초기화하기 > 외부에서 메소드 인자를 통해 생성자 주입 + 각 이벤트에 필요한 파라미터 전달
        event.getEventDiscountPrice()
    */
    private ChristmasEvent christmasEvent = new ChristmasEvent();
    private WeekdayEvent weekdayEvent = new WeekdayEvent();
    private WeekendEvent weekendEvent = new WeekendEvent();
    private SpecialEvent specialEvent = new SpecialEvent();
    private GiftEvent giftEvent = new GiftEvent();

    /* FIXME: 이벤트 별로 할인 계산하도록 분리하기
        하나의 메소드에 모든 이벤트 할인계산 메소드가 모여 있어서 각 메소드에 불필요한 파라미터도 전달받고 있음
        무의미한 이벤트 별 메소드분리로 의존성이 그대로 전파된다.
    */
    public EventDiscount getTotalEventDiscount(ReservationDate reservationDate, List<ReservationMenu> menuList,
                                               int priceBeforeDiscount) {
        int christmasPrice = getChristmasEventDiscountPrice(reservationDate.getReservedDate());
        int weekdayPrice = getWeekdayEventDiscountPrice(reservationDate.getDay(), menuList);
        int weekendPrice = getWeekendEventDiscountPrice(reservationDate.getDay(), menuList);
        int specialPrice = getSpecialEventDiscountPrice(reservationDate.getDay(),
                reservationDate.getReservationFullDate());
        int giftPrice = getGiftEventDiscountPrice(priceBeforeDiscount);
        //FIXME: EventDiscount 에 넣지말고 각 이벤트별 도메인에 discountPrice 멤버를 추가해서 set하는건?
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
