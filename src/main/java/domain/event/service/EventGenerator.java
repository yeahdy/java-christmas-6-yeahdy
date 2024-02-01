package domain.event.service;

import constants.UserEventMessageConstant;
import domain.event.model.EventDiscount;
import domain.event.model.EventType;
import domain.reservation.model.ReservationMenu;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EventGenerator {

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
    // NOTE: EventDiscount는 할인된 금액 정보를 가지고 있는 객체
    //  eventDiscount가 할인된 금액정보를 클라이언트에게 전달하도록 변경하기
    //  결과1:이벤트 할인가격이 어떤 이벤트인지 알 수 없기 때문에 enum 타입을 만들어서 이벤트정보-할인가격을 연관지음
    //  결과2: EventDiscount의 필드 getter가 사라지고, 메소드 전달을 통해 결합도를 낮춤
    public List<String> getBenefitsList(EventDiscount eventDiscount) {
        List<String> benefitsList = new ArrayList<>();
        Map<EventType,Integer> eventBenefitsInfo = eventDiscount.getEventBenefitsInfo();

        for(EventType event : EventType.values()){
            int price = eventBenefitsInfo.get(event);
            if(price == 0){
                continue;
            }
            benefitsList.add(addPriceMessage(price, event.getName()));
        }
        return benefitsList;
    }

    // NOTE: 같은 구조로 반복되는 메소드 구조
    //  동일한 형태로 요구사항 변경 시 모두 함께 변경되는 코드이기 때문에 인자를 추가해서 중복코드를 제거하기
    private String addPriceMessage(int price, String eventName) {
        String message = UserEventMessageConstant.BENEFITS_PRICE_LIST.replace("{event}", eventName);
        message = message.replace("{price}", getCommaPrice(price));
        return message;
    }


    private String getCommaPrice(int price) {
        if (price == 0) {
            return BigInteger.ZERO + "";
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(price);
    }

}
