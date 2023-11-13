package service;

import constants.ErrorCodeConstant;
import domain.ReservationMenu;
import java.util.ArrayList;
import java.util.List;

public class ReservationMenuService {

    private ReservationMenu reservationMenu = new ReservationMenu();

    /** 사용자 메뉴 입력 유효성 검사
     *
     * @param orders "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1" 문자열 타입
     * @return {"티본스테이크-1","바비큐립-1","초코케이크-2","제로콜라-1"} 문자열 배열 타입
     */
    public String[] validateOrderList(String orders){
        String[] orderList = orders.split(",");

        for(String order : orderList){
            reservationMenu.validateOrder(order);
        }
        return orderList;
    }

    public List<ReservationMenu> validateReservationMenu(String[] orderList) throws IllegalArgumentException {
        List<ReservationMenu> reservationMenuList = new ArrayList<>();

        if(reservationMenu.isDuplicatedMenu(orderList)){
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_MENU_ERROR);
        }

        for(String order : orderList){
            ReservationMenu validatedReservationMenu = reservationMenu.getValidatedReservationMenu(order);
            if(validatedReservationMenu == null){
                throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_MENU_ERROR);
            }
            reservationMenuList.add(validatedReservationMenu);
        }

        return reservationMenuList;
    }

}
