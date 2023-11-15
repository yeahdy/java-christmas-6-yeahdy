package domain.reservation.model;

import domain.Menu;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import validators.ReservationMenuValidator;

public class ReservationMenu {

    private Menu menu;
    private int count;

    public ReservationMenu(){}

    private ReservationMenu(Menu menu, int count){
        this.menu = menu;
        this.count = count;
    }

    /** 메뉴-수량 유효성 검사 */
    public void validateOrder(String order){
        ReservationMenuValidator.validateString(order);
        String[] orderFormat = ReservationMenuValidator.validateOrderFormat(order);
        ReservationMenuValidator.validateOrderCount(orderFormat);
    }

    /** 주문한 메뉴가 20개를 초과한 경우 */
    public boolean isExceedMenuCount(String[] orderList){
        final int MAX_MENU_COUNT = 20;
        List<String> countList = selectMenuOrCount(orderList,1);
        return ReservationMenuValidator.isExceedCount(MAX_MENU_COUNT, countList);
    }

    /** 음료만 단독 주문한 경우  */
    public boolean isOnlyDrinkMenu(String[] orderList){
        List<String> menuList = selectMenuOrCount(orderList,0);
        return ReservationMenuValidator.isOnlyDrinkMenu(menuList);
    }

    /** 중복 메뉴를 입력한 경우 true 반환, 중복아닐 경우 false */
    public boolean isDuplicatedMenu(String[] orderList){
        List<String> menuList = selectMenuOrCount(orderList,0);
        return ReservationMenuValidator.isDuplicatesList(menuList);
    }

    private List<String> selectMenuOrCount(String[] orderList, int selectNumber){
        return Arrays.stream(orderList)
                .map(value -> value.split("-")[selectNumber])
                .collect(Collectors.toList());
    }


    /** 고객이 메뉴판에 없는 메뉴를 입력한 경우 */
    public ReservationMenu getValidatedReservationMenu(String order){
        String[] foodAndCount = order.split("-");
        String food = foodAndCount[0];
        int count = Integer.parseInt(foodAndCount[1]);

        Menu menu = Menu.getMenu(food);
        if(menu == null){
            return null;
        }

        return new ReservationMenu(menu,count);
    }

}
