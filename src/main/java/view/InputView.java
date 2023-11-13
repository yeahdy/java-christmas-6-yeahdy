package view;

import static constants.EventMessageConstant.GREETING;
import static constants.EventMessageConstant.WHEN_IS_THE_DATE;

import camp.nextstep.edu.missionutils.Console;
import utils.PrintUtils;
import validators.EventValidator;

public class InputView {

    public String readDate() {
        PrintUtils.println(GREETING);
        PrintUtils.println(WHEN_IS_THE_DATE);

        String date = Console.readLine();
        EventValidator.validateNumber(date);
        return date;
    }

}
