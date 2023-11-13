package domain;

import validators.ReservationMenuValidator;

public class ReservationMenu {

    private Menu menu;

    private int count;

    public ReservationMenu(){}


    /** 사용자 메뉴 입력 유효성 검사
     *
     * @param orders "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1" 문자열 타입
     * @return {"티본스테이크-1","바비큐립-1","초코케이크-2","제로콜라-1"} 문자열 배열 타입
     */
    public String[] validateOrder(String orders){
        String[] orderList = orders.split(",");

        for(String order : orderList){
            ReservationMenuValidator.validateString(order);
            String[] orderFormat = ReservationMenuValidator.validateOrderFormat(order);
            ReservationMenuValidator.validateOrderCount(orderFormat);
        }

        return orderList;
    }


}
