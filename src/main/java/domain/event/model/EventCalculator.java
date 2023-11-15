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

}
