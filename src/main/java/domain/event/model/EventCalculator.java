package domain.event.model;

import domain.reservation.model.ReservationMenu;
import domain.user.UserReceipt;

public class EventCalculator {

    /** 할인 전 총주문 금액 */
    public int getTotalMenuPrice(ReservationMenu reservationMenu){
        return reservationMenu.getMenu().getPrice() * reservationMenu.getCount();
    }

    /** 총혜택 금액 */
    public int getTotalBenefitsPrice(EventDiscount eventDiscount){
        int totalBenefitsPrice = 0;
        totalBenefitsPrice += eventDiscount.getChristmasPrice();
        totalBenefitsPrice += eventDiscount.getWeekdayPrice();
        totalBenefitsPrice += eventDiscount.getWeekendPrice();
        totalBenefitsPrice += eventDiscount.getSpecialPrice();
        totalBenefitsPrice += eventDiscount.getGiftPrice();
        return totalBenefitsPrice;
    }

    /** 할인 후 예상 결제 금액 */
    public int getPriceAfterDiscount(UserReceipt userReceipt, int giftPrice){
        int totalEventPrice = userReceipt.getTotalBenefitsPrice() - giftPrice;
        return userReceipt.getPriceBeforeDiscount() - totalEventPrice;
    }


}
