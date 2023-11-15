package domain.event.model;

import constants.UserEventMessageConstant;
import domain.reservation.model.ReservationMenu;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class UserEventGenerator {

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

    /** 총혜택 금액 */
    public String getMenuPrice(int price){
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        String formattedNumber = decimalFormat.format(price);

        String message = UserEventMessageConstant.MENU_PRICE;
        return message.replace("{price}",String.valueOf(formattedNumber));
    }

    /** 증정 메뉴 */

    /** 혜택 내역 */

}
