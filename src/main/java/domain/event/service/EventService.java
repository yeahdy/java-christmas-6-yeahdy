package domain.event.service;

import domain.event.model.EventDiscount;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import domain.user.dto.UserPriceDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EventService {

    private EventCalculator eventCalculator;
    private EventGenerator eventGenerator;
    private EventFacade eventFacade;

    public EventService(EventCalculator eventCalculator, EventGenerator eventGenerator,
                        EventFacade eventFacade) {
        this.eventCalculator = eventCalculator;
        this.eventGenerator = eventGenerator;
        this.eventFacade = eventFacade;
    }

    public String selectMenuPrice(int priceBeforeDiscount) {
        return eventGenerator.getValuePrice(priceBeforeDiscount);
    }

    public EventDiscount getTotalEventDiscount(ReservationDate reservationDate, List<ReservationMenu> menuList, int priceBeforeDiscount) {
        return eventFacade.getTotalEventDiscount(reservationDate, menuList, priceBeforeDiscount);
    }

    public String selectGiftEventDiscountPrice(EventDiscount eventDiscount) {
        if (eventDiscount == null || eventDiscount.getGiftPrice() == 0) {
            return "없음";
        }
        final String gift = "샴페인";
        return eventGenerator.getUserGift(gift, 1);
    }

    public List<String> selectBenefitsList(EventDiscount eventDiscount) {
        if (eventDiscount == null) {
            return new ArrayList<>(Collections.singleton(("없음")));
        }
        return eventGenerator.getBenefitsList(eventDiscount);
    }

    public UserPriceDto selectTotalBenefitsPrice(EventDiscount eventDiscount, int priceBeforeDiscount) {
        int totalBenefitsPrice = eventCalculator.getTotalBenefitsPrice(eventDiscount);
        return new UserPriceDto(priceBeforeDiscount, totalBenefitsPrice);

    }

    public String selectTotalBenefitsPrice(int totalBenefitsPrice){
        return "-" + eventGenerator.getValuePrice(totalBenefitsPrice);
    }

    public String selectPriceAfterDiscount(UserPriceDto userPriceDto, EventDiscount eventDiscount) {
        if (eventDiscount == null) {
            return eventGenerator.getValuePrice(userPriceDto.getPriceBeforeDiscount());
        }
        int priceAfterDiscount = eventCalculator.getPriceAfterDiscount(userPriceDto, eventDiscount.getGiftPrice());
        return eventGenerator.getValuePrice(priceAfterDiscount);
    }

}
