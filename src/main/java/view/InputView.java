package view;

import static constants.EventMessageConstant.WHEN_IS_THE_DATE;

import camp.nextstep.edu.missionutils.Console;
import utils.PrintUtils;
import validators.EventValidator;

public class InputView {

    public int readDate() {
        PrintUtils.println(WHEN_IS_THE_DATE);

        String date = Console.readLine();
        return EventValidator.validateNumber(date);
    }

}
