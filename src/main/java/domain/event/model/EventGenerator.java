package domain.event.model;

import constants.UserEventMessageConstant;
import domain.reservation.model.ReservationMenu;
import java.util.ArrayList;
import java.util.List;

public class EventGenerator {

    /** 주문 메뉴 */
    public List<String> getUserMenuList(List<ReservationMenu> reservationMenuList){
        List<String> userOrderMenuList = new ArrayList<>();

        for(ReservationMenu reservationMenu : reservationMenuList){
            String message = UserEventMessageConstant.ORDER_MENU_AND_COUNT;
            message = message.replace("{food}",reservationMenu.getMenu().getFood());
            message = message.replace("{count}",String.valueOf(reservationMenu.getCount()));

            userOrderMenuList.add(message);
        }

        return userOrderMenuList;
    }

    /** 증정 메뉴 */

    /** 혜택 내역 */

}
