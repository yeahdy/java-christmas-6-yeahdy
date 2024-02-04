package domain.event.service;

import domain.event.model.EventDiscount;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import domain.user.dto.UserPriceDto;
import java.util.List;

public class EventService {

    private EventGenerator eventGenerator;
    private EventFacade eventFacade;

    public EventService(EventGenerator eventGenerator, EventFacade eventFacade) {
        this.eventGenerator = eventGenerator;
        this.eventFacade = eventFacade;
    }

    public String selectMenuPrice(int priceBeforeDiscount) {
        return eventGenerator.getValuePrice(priceBeforeDiscount);
    }

    public EventDiscount getTotalEventDiscount(ReservationDate reservationDate, List<ReservationMenu> menuList,
                                               int priceBeforeDiscount) {

        return eventFacade.getTotalEventDiscount(reservationDate, menuList, priceBeforeDiscount);
    }

    public String selectGiftEventDiscountPrice(EventDiscount eventDiscount) {
        if(eventDiscount != null && eventDiscount.existGiftPrice()){
            eventGenerator.getUserGift("샴페인", 1);
        }
        return "없음";
    }

    public List<String> selectBenefitsList(EventDiscount eventDiscount) {
        return eventGenerator.getBenefitsList(eventDiscount);
    }

    public UserPriceDto selectTotalBenefitsPrice(EventDiscount eventDiscount, int priceBeforeDiscount) {
        int totalBenefitsPrice = 0;
        if (eventDiscount != null) {
            totalBenefitsPrice = eventDiscount.getTotalBenefitsPrice();
        }
        return new UserPriceDto(priceBeforeDiscount, totalBenefitsPrice);

    }

    public String selectTotalBenefitsPrice(int totalBenefitsPrice) {
        return eventGenerator.getValuePrice(totalBenefitsPrice);
    }


    public String selectPriceAfterDiscount(UserPriceDto userPriceDto, EventDiscount eventDiscount) {
        if (eventDiscount == null) {
            return eventGenerator.getValuePrice(userPriceDto.getPriceBeforeDiscount());
        }
        return eventGenerator.getValuePrice(
                eventDiscount.getPriceAfterDiscount(userPriceDto.getTotalBenefitsPrice(),
                        userPriceDto.getPriceBeforeDiscount()));
    }

}
