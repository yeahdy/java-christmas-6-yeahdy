package domain.event.service;

import domain.event.model.EventDiscount;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import dto.UserPriceDto;
import domain.user.UserReservation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventService {

    private UserReservation userReservation;
    private UserPriceDto userPriceDto;

    private EventCalculateGenerator eventCalculateGenerator = new EventCalculateGenerator();
    private UserEventGenerator userEventGenerator = new UserEventGenerator();
    private EventFacade eventFacade = new EventFacade();

    public UserReservation getUserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList) {
        int totalPrice = eventCalculateGenerator.getTotalMenuPrice(menuList);
        userPriceDto = new UserPriceDto(totalPrice);

        boolean hasEventBenefit = 10000 < totalPrice;
        userReservation = new UserReservation(reservationDate, menuList, hasEventBenefit);
        return userReservation;
    }

    public List<String> selectUserMenuList(List<ReservationMenu> userMenuList) {
        return userEventGenerator.getUserMenuList(userMenuList);
    }

    public String selectMenuPrice() {
        return userEventGenerator.getValuePrice(userPriceDto.getPriceBeforeDiscount());
    }

    public EventDiscount getTotalEventDiscount() {
        if (!userReservation.isHasEventBenefit()) {
            return null;
        }

        return eventFacade.getTotalEventDiscount(
                userReservation.getReservationDate(),
                userReservation.getMenuList(),
                userPriceDto.getPriceBeforeDiscount());
    }

    public String selectGiftEventDiscountPrice(EventDiscount eventDiscount) {
        if (eventDiscount == null || eventDiscount.getGiftPrice() == 0) {
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

    public String selectTotalBenefitsPrice(EventDiscount eventDiscount) {
        if (eventDiscount == null) {
            return "없음";
        }
        int totalBenefitsPrice = eventCalculateGenerator.getTotalBenefitsPrice(eventDiscount);
        userPriceDto.setTotalBenefitsPrice(totalBenefitsPrice);
        return "-" + userEventGenerator.getValuePrice(totalBenefitsPrice);
    }

    public String selectPriceAfterDiscount(EventDiscount eventDiscount) {
        int priceBeforeDiscount = userPriceDto.getPriceBeforeDiscount();
        if (eventDiscount == null) {
            return userEventGenerator.getValuePrice(priceBeforeDiscount);
        }
        int priceAfterDiscount = eventCalculateGenerator.getPriceAfterDiscount(userPriceDto, eventDiscount);
        return userEventGenerator.getValuePrice(priceAfterDiscount);
    }

    public UserPriceDto selectUserReservation(){
        return userPriceDto;
    }

}
