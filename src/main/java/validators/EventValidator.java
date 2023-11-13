package validators;

import constants.ErrorCodeConstant;
public class EventValidator {

    /** 숫자로 변환이 안될 경우 예외 발생 */
    public static void validateNumber(String characters){
        try{
            Integer.parseInt(characters);
        }catch (IllegalArgumentException iae){
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_DATE_ERROR);
        }
    }

}
