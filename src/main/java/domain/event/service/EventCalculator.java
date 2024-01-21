package domain.event.service;

import domain.event.model.EventDiscount;
import domain.reservation.model.ReservationMenu;
import domain.user.dto.UserPriceDto;
import java.util.List;

public class EventCalculator {

    /**
     * 할인 전 총주문 금액
     */
    public int getTotalMenuPrice(List<ReservationMenu> reservationMenuList) {
        int totalMenuPrice = 0;
        for (ReservationMenu reservationMenu : reservationMenuList) {
            totalMenuPrice += reservationMenu.getMenu().getPrice() * reservationMenu.getCount();
        }
        return totalMenuPrice;
    }

    /**
     * 총혜택 금액
     */
    public int getTotalBenefitsPrice(EventDiscount eventDiscount) {
        int totalBenefitsPrice = 0;
        totalBenefitsPrice += eventDiscount.getChristmasPrice();
        totalBenefitsPrice += eventDiscount.getWeekdayPrice();
        totalBenefitsPrice += eventDiscount.getWeekendPrice();
        totalBenefitsPrice += eventDiscount.getSpecialPrice();
        totalBenefitsPrice += eventDiscount.getGiftPrice();
        return totalBenefitsPrice;
    }

    /**
     * 할인 후 예상 결제 금액
     */
    public int getPriceAfterDiscount(UserPriceDto userPriceDto, int giftPrice) {
        int totalEventPrice = userPriceDto.getTotalBenefitsPrice() - giftPrice;
        return userPriceDto.getPriceBeforeDiscount() - totalEventPrice;
    }

}
