package validators;

import constants.ErrorCodeConstant;
import domain.menu.Menu;
import domain.menu.MenuType;
import domain.reservation.model.ReservationMenu;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationMenuValidator {
    public static final int MIN_ORDER_COUNT = 1;

    /**
     * 메뉴-수량 유효성 검사
     * - 공백 검사
     * - "음식이름-수량" 형식이 아닐 경우 유효성 검사 실패
     * - 수량이 숫자가 아니거나, 수량이 1 미만일 경우 유효성 검사 실패
     */
    public void validateOrder(String order) {
        validateString(order);
        String[] orderFormat = validateOrderFormat(order);
        validateOrderCount(orderFormat);
    }

    private String validateString(String order) {
        if (order.isBlank()) {
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_MENU_ERROR);
        }
        return order;
    }

    private String[] validateOrderFormat(String order) {
        final String DELIMITER = "-";
        String[] orderFormat = order.split(DELIMITER);

        if (orderFormat.length != 2) {
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_MENU_ERROR);
        }
        return orderFormat;
    }

    private void validateOrderCount(String[] orderFormat) {
        int orderCount;
        try {
            orderCount = Integer.parseInt(orderFormat[1]);
        } catch (NumberFormatException efe) {
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_MENU_ERROR);
        }

        if (orderCount < MIN_ORDER_COUNT) {
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_MENU_ERROR);
        }
    }


    /**
     * 주문한 메뉴가 20개를 초과한 경우 true, 아닐 경우 false 리턴
     */
    public boolean isExceedMenuCount(String[] orderList) {
        final int MAX_MENU_COUNT = 20;
        List<String> countList = selectMenuOrCount(orderList, 1);
        return isExceedCount(MAX_MENU_COUNT, countList);
    }

    private boolean isExceedCount(int maxNumber, List<String> menuCount) {
        int totalMenuCount = menuCount.stream()
                .mapToInt(Integer::parseInt)
                .sum();
        return totalMenuCount > maxNumber;
    }


    /**
     * 음료만 단독 주문한 경우
     */
    public boolean isOnlyDrinkMenu(String[] orderList) {
        List<String> menuList = selectMenuOrCount(orderList, 0);
        return isOnlyDrinkMenu(menuList);
    }

    private boolean isOnlyDrinkMenu(List<String> menuList) {
        int menuListCount = menuList.size();
        int drinkCountInMenuList = 0;

        for (String menu : menuList) {
            if (MenuType.DRINK.equals(Menu.getMenuType(menu))) {
                drinkCountInMenuList++;
            }
        }

        return menuListCount == drinkCountInMenuList;
    }


    /**
     * 중복 메뉴를 입력한 경우 true 반환, 중복아닐 경우 false
     */
    public boolean isDuplicatedMenu(String[] orderList) {
        List<String> menuList = selectMenuOrCount(orderList, 0);
        return isDuplicatesList(menuList);
    }

    private boolean isDuplicatesList(List<String> orderList) {
        List<String> distinctNumbers = orderList.stream()
                .distinct()
                .collect(Collectors.toList());

        return distinctNumbers.size() != orderList.size();
    }

    private List<String> selectMenuOrCount(String[] orderList, int selectNumber) {
        return Arrays.stream(orderList)
                .map(value -> value.split("-")[selectNumber])
                .collect(Collectors.toList());
    }


    /**
     * 고객이 메뉴판에 없는 메뉴를 입력한 경우
     */
    public ReservationMenu getValidatedReservationMenu(String order) {
        String[] foodAndCount = order.split("-");
        String food = foodAndCount[0];
        int count = Integer.parseInt(foodAndCount[1]);

        Menu menu = Menu.getMenu(food);
        if (menu == null) {
            return null;
        }

        return new ReservationMenu(menu, count);
    }

}
