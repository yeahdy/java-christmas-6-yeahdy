package domain.event.model;

import domain.Menu;
import java.util.List;

public class EventCalculator {

    /** 할인 전 총주문 금액 */
    public int getTotalMenuPrice(List<Menu> menuList){
        return menuList.stream()
                .mapToInt(Menu::getPrice)
                .sum();
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

}
