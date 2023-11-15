package domain.event.service;

import constants.UserEventMessageConstant;
import domain.event.model.EventDiscount;
import domain.reservation.model.ReservationMenu;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class UserEventGenerator {

    /**
     * 주문 메뉴
     */
    public List<String> getUserMenuList(List<ReservationMenu> reservationMenuList) {
        List<String> userOrderMenuList = new ArrayList<>();

        for (ReservationMenu reservationMenu : reservationMenuList) {
            String message = UserEventMessageConstant.ORDER_MENU_AND_COUNT;
            message = message.replace("{food}", reservationMenu.getMenu().getFood());
            message = message.replace("{count}", String.valueOf(reservationMenu.getCount()));

            userOrderMenuList.add(message);
        }

        return userOrderMenuList;
    }

    /**
     * 총혜택 금액
     */
    public String getValuePrice(int price) {
        String message = UserEventMessageConstant.MENU_PRICE;
        return message.replace("{price}", getCommaPrice(price));
    }

    /**
     * 증정 메뉴
     */
    public String getUserGift(String gift, int count) {
        String message = UserEventMessageConstant.ORDER_MENU_AND_COUNT;
        message = message.replace("{food}", gift);
        message = message.replace("{count}", String.valueOf(count));
        return message;
    }

    /**
     * 혜택 내역
     */
    public List<String> getBenefitsList(EventDiscount eventDiscount) {
        List<String> benefitsList = new ArrayList<>();
        if (eventDiscount.getChristmasPrice() != 0) {
            String message = UserEventMessageConstant.BENEFITS_PRICE_LIST
                    .replace("{event}", UserEventMessageConstant.CHRISTMAS_DISCOUNT);
            message = message.replace("{price}", getCommaPrice(eventDiscount.getChristmasPrice()));
            benefitsList.add(message);
        }

        if (eventDiscount.getWeekdayPrice() != 0) {
            String message = UserEventMessageConstant.BENEFITS_PRICE_LIST
                    .replace("{event}", UserEventMessageConstant.WEEKDAY_DISCOUNT);
            message = message.replace("{price}", getCommaPrice(eventDiscount.getWeekdayPrice()));
            benefitsList.add(message);
        }

        if (eventDiscount.getWeekendPrice() != 0) {
            String message = UserEventMessageConstant.BENEFITS_PRICE_LIST
                    .replace("{event}", UserEventMessageConstant.WEEKEND_DISCOUNT);
            message = message.replace("{price}", getCommaPrice(eventDiscount.getWeekendPrice()));
            benefitsList.add(message);
        }

        if (eventDiscount.getSpecialPrice() != 0) {
            String message = UserEventMessageConstant.BENEFITS_PRICE_LIST
                    .replace("{event}", UserEventMessageConstant.SPECIAL_DISCOUNT);
            message = message.replace("{price}", getCommaPrice(eventDiscount.getSpecialPrice()));
            benefitsList.add(message);
        }

        if (eventDiscount.getGiftPrice() != 0) {
            String message = UserEventMessageConstant.BENEFITS_PRICE_LIST
                    .replace("{event}", UserEventMessageConstant.GIFT_DISCOUNT);
            message = message.replace("{price}", getCommaPrice(eventDiscount.getGiftPrice()));
            benefitsList.add(message);
        }

        return benefitsList;
    }

    private String getCommaPrice(int price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(price);
    }

}
