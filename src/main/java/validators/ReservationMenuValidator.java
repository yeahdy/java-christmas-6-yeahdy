package validators;

import constants.ErrorCodeConstant;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationMenuValidator {
    public static final int MIN_ORDER_COUNT = 1;

    public static String validateString(String order){
        if(order.isBlank()){
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_MENU_ERROR);
        }
        return order;
    }


    /** "음식이름-수량" 형식이 아닐 경우 유효성 검사 실패 */
    public static String[] validateOrderFormat(String order){
        final String DELIMITER = "-";
        String[] orderFormat = order.split(DELIMITER);

        if (orderFormat.length != 2) {
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_MENU_ERROR);
        }
        return orderFormat;
    }

    /** 수량이 숫자가 아니거나, 수량이 1 미만일 경우 유효성 검사 실패 */
    public static void validateOrderCount(String[] orderFormat){
        int orderCount;
        try{
            orderCount = Integer.parseInt(orderFormat[1]);
        }catch (NumberFormatException efe){
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_MENU_ERROR);
        }

        if (orderCount < MIN_ORDER_COUNT) {
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_MENU_ERROR);
        }
    }

    /** 최대 갯수를 초과했을 경우 true, 아닐 경우 false 리턴 */
    public static boolean isExceedCount(int maxNumber, String[] orderList) {
        if(orderList.length > maxNumber){
            return true;
        }
        return false;
    }

    /** List의 원소 중 중복이 있을 경우 true, 아닐 경우 false 리턴 */
    public static boolean isDuplicatesList(List<String> orderList) {
        List<String> distinctNumbers = orderList.stream()
                .distinct()
                .collect(Collectors.toList());

        return distinctNumbers.size() != orderList.size();
    }

}
