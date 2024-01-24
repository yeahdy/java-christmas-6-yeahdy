package domain.event.service;

import domain.event.model.ChristmasEvent;
import domain.event.model.Event;
import domain.event.model.EventDiscount;
import domain.event.model.GiftEvent;
import domain.event.model.SpecialEvent;
import domain.event.model.WeekdayEvent;
import domain.event.model.WeekendEvent;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import java.util.List;

public class EventFacade {

    /* FIXME: Event 추상클래스 만들기, 인자 갯수/타입이 다름
        이벤트 별 할인 금액 계산하기
        누구와 협력? 이벤트 별로 협력이 필요한 요소가 다름 > 할인을 하기 위한 요소를 전달해줘서 할인을 하도록 만들기
        Event 추상클래스의 자식클래스를 생성자 초기화하여 메소드 인자로 넘기기
    */
    public EventDiscount getTotalEventDiscount(ReservationDate reservationDate, List<ReservationMenu> menuList,
                                               int priceBeforeDiscount) {
        int christmasPrice = getTotalEventDiscount(new ChristmasEvent(reservationDate.getReservedDate()));
        int weekdayPrice = getTotalEventDiscount(new WeekdayEvent(reservationDate.getDay(), menuList));
        int weekendPrice = getTotalEventDiscount(new WeekendEvent(reservationDate.getDay(), menuList));
        int specialPrice = getTotalEventDiscount(new SpecialEvent(reservationDate.getDay(), reservationDate.getReservationFullDate()));
        int giftPrice = getTotalEventDiscount(new GiftEvent(priceBeforeDiscount));

        return new EventDiscount(christmasPrice, weekdayPrice, weekendPrice, specialPrice, giftPrice);
    }

    /* FIXME: 이벤트 별로 할인 계산하도록 분리하기
        하나의 메소드에 모든 이벤트 할인계산 메소드가 모여 있어서 각 메소드에 불필요한 파라미터도 전달받고 있음
        무의미한 이벤트 별 메소드분리로 의존성이 그대로 전파된다.
    */
    private int getTotalEventDiscount(Event event) {
        return event.selectDiscountPrice();
    }

}
