package controller;

import domain.badge.Badge;
import domain.user.UserReceiptPriceInfo;
import utils.PrintUtils;
import view.OutputView;

public class BadgeController {

    private OutputView outputView = new OutputView();
    private UserReceiptPriceInfo userReceiptPriceInfo;

    public BadgeController(UserReceiptPriceInfo userReceiptPriceInfo) {
        this.userReceiptPriceInfo = userReceiptPriceInfo;
    }

    public void createEventBadge() {
        outputView.printEventBadge();
        int totalBenefitsPrice = userReceiptPriceInfo.getTotalBenefitsPrice();
        PrintUtils.println(Badge.getBadgeName(totalBenefitsPrice));
    }

}
