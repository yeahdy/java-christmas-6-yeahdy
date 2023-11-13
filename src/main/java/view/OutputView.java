package view;


import static constants.EventMessageConstant.GREETING;
import static constants.EventMessageConstant.ORDER_MENU;

import utils.PrintUtils;

public class OutputView {

    public void printGreeting(){
        PrintUtils.println(GREETING);
    }

    public void printOrderMenu() {
        PrintUtils.println(ORDER_MENU);
    }

}
