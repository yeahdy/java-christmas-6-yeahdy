package domain.reservation.service;

import constants.ErrorCodeConstant;
import domain.reservation.model.ReservationMenu;
import java.util.ArrayList;
import java.util.List;
import validators.ReservationMenuValidator;

public class ReservationMenuService {
    private ReservationMenuValidator reservationMenuValidator;
    public ReservationMenuService(){
        reservationMenuValidator = new ReservationMenuValidator();
    }

    /**
     * 사용자 메뉴 입력 유효성 검사 - 공백이 있는지 - 입력 형식이 올바른지 - 20개까지 주문 했는지
     *
     * @param orders "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1" 문자열 타입
     * @return {"티본스테이크-1","바비큐립-1","초코케이크-2","제로콜라-1"} 문자열 배열 타입
     */
    public String[] validateOrderList(String orders) {
        String[] orderList = orders.split(",");

        for (String order : orderList) {
            reservationMenuValidator.validateOrder(order);
        }
        if (reservationMenuValidator.isExceedMenuCount(orderList)) {
            throw new IllegalArgumentException(ErrorCodeConstant.EXCEED_MENU_COUNT_ERROR);
        }
        return orderList;
    }


    /** 예약한 메뉴 유효성 검사 - 음료만 단독 주문 하지 않았는지 - 중복된 메뉴는 없는지 - 메뉴에 있는 음식만 주문 했는지 */
    public List<ReservationMenu> validateReservationMenu(String[] orderList) throws IllegalArgumentException {
        List<ReservationMenu> reservationMenuList = new ArrayList<>();
        if (reservationMenuValidator.isDuplicatedMenu(orderList)) {
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_MENU_ERROR);
        }
        for (String order : orderList) {
            ReservationMenu validatedReservationMenu = reservationMenuValidator.getValidatedReservationMenu(order);
            if (validatedReservationMenu == null) {
                throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_MENU_ERROR);
            }
            reservationMenuList.add(validatedReservationMenu);
        }
        if (reservationMenuValidator.isOnlyDrinkMenu(orderList)) {
            throw new IllegalArgumentException(ErrorCodeConstant.IS_ONLY_DRINK_ERROR);
        }
        return reservationMenuList;
    }

}
