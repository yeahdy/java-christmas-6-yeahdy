package validators;

import constants.ErrorCodeConstant;

public class ReservationDateValidator {

    public static final int MIN_DATE_NUMBER = 1;
    public static final int MAX_DATE_NUMBER = 31;

    /** 숫자로 변환이 안될 경우 예외 발생 */
    public static int validateNumber(String characters){
        try{
            return Integer.parseInt(characters);
        }catch (IllegalArgumentException iae){
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_DATE_ERROR);
        }
    }

    /** 정수가 기준을 벗어날 경우 예외 발생 */
    public static void validateBetweenDate(int number) {
        if (number < MIN_DATE_NUMBER || number > MAX_DATE_NUMBER) {
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_DATE_ERROR);
        }
    }

}
