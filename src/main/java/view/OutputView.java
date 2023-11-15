package view;


import static constants.EventMessageConstant.BENEFITS_LIST;
import static constants.EventMessageConstant.CHECK_BENEFITS;
import static constants.EventMessageConstant.EVENT_BADGE;
import static constants.EventMessageConstant.GIFT_MENU;
import static constants.EventMessageConstant.GREETING;
import static constants.EventMessageConstant.ORDER_MENU;
import static constants.EventMessageConstant.PRICE_AFTER_DISCOUNT;
import static constants.EventMessageConstant.PRICE_BEFORE_DISCOUNT;
import static constants.EventMessageConstant.TOTAL_BENEFITS_PRICE;

import utils.PrintUtils;

public class OutputView {

    public void printGreeting() {
        PrintUtils.println(GREETING);
    }

    public void printCheckBenefit(String date) {
        PrintUtils.replacePrintf(CHECK_BENEFITS, date);
    }

    public void printOrderMenu() {
        PrintUtils.println(ORDER_MENU);
    }

    public void printPriceBeforeDiscount() {
        PrintUtils.println(PRICE_BEFORE_DISCOUNT);
    }

    public void printGiftMenu() {
        PrintUtils.println(GIFT_MENU);
    }

    public void printBenefitsList() {
        PrintUtils.println(BENEFITS_LIST);
    }

    public void printTotalBenefitsPrice() {
        PrintUtils.println(TOTAL_BENEFITS_PRICE);
    }

    public void printPriceAfterDiscount() {
        PrintUtils.println(PRICE_AFTER_DISCOUNT);
    }

    public void printEventBadge() {
        PrintUtils.println(EVENT_BADGE);
    }

}
