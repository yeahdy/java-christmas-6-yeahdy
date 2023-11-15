package domain.event.service;

import domain.event.model.EventDiscount;
import domain.event.model.EventFacade;
import domain.event.model.UserEventGenerator;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import domain.user.UserReceipt;
import domain.user.UserReservation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventService {

    private UserReservation userReservation;
    private UserReceipt userReceipt;
    private EventCalculatorService eventCalculatorService = new EventCalculatorService();
    private UserEventGenerator userEventGenerator = new UserEventGenerator();
    private EventFacade eventFacade = new EventFacade();

    public UserReservation getUserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList) {
        int totalPrice = eventCalculatorService.isEventBenefit(menuList);
        userReceipt = new UserReceipt(totalPrice);

        boolean hasEventBenefit = 10000 < totalPrice;
        userReservation = new UserReservation(reservationDate, menuList, hasEventBenefit);
        return userReservation;
    }

    public List<String> selectUserMenuList(List<ReservationMenu> userMenuList) {
        return userEventGenerator.getUserMenuList(userMenuList);
    }

    public String selectMenuPrice() {
        return userEventGenerator.getMenuPrice(userReceipt.getPriceBeforeDiscount());
    }

    public EventDiscount getTotalEventDiscount() {
        if(!userReservation.isHasEventBenefit()){
            return null;
        }

        return eventFacade.getTotalEventDiscount(
                userReservation.getReservationDate(),
                userReservation.getMenuList(),
                userReceipt.getPriceBeforeDiscount());
    }

    public String selectGiftEventDiscountPrice(EventDiscount eventDiscount) {
        if (eventDiscount == null) {
            return "없음";
        }
        final String gift = "샴페인";
        return userEventGenerator.getUserGift(gift, 1);
    }

    public List<String> selectBenefitsList(EventDiscount eventDiscount) {
        if (eventDiscount == null) {
            return new ArrayList<>(Collections.singleton(("없음")));
        }
        return userEventGenerator.getBenefitsList(eventDiscount);
    }


}
