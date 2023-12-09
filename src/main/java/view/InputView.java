package view;

import static constants.EventMessageConstant.WHAT_IS_THE_MENU;
import static constants.EventMessageConstant.WHEN_IS_THE_DATE;

import camp.nextstep.edu.missionutils.Console;
import constants.ErrorCodeConstant;
import utils.PrintUtils;

public class InputView {

    public int readDate() {
        PrintUtils.println(WHEN_IS_THE_DATE);
        String date = Console.readLine();
        try {
            return Integer.parseInt(date);
        } catch (IllegalArgumentException iae) {
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_DATE_ERROR);
        }
    }

    public String readOrder() {
        PrintUtils.println(WHAT_IS_THE_MENU);
        String order = Console.readLine();
        if (order.isBlank()) {
            throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_MENU_ERROR);
        }
        return order;
    }

}
