package view;

import static constants.EventMessageConstant.WHAT_IS_THE_MENU;
import static constants.EventMessageConstant.WHEN_IS_THE_DATE;

import camp.nextstep.edu.missionutils.Console;
import utils.PrintUtils;
import validators.ReservationDateValidator;
import validators.ReservationMenuValidator;

public class InputView {

    public int readDate() {
        PrintUtils.println(WHEN_IS_THE_DATE);

        String date = Console.readLine();
        return ReservationDateValidator.validateNumber(date);
    }

    public String readOrder() {
        PrintUtils.println(WHAT_IS_THE_MENU);

        String order = Console.readLine();
        return ReservationMenuValidator.validateString(order);
    }

}
