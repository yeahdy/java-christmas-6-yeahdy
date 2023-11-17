package controller;

import domain.badge.Badge;
import dto.UserPriceDto;
import utils.PrintUtils;
import view.OutputView;

public class BadgeController {

    private OutputView outputView = new OutputView();
    private UserPriceDto userPriceDto;

    public BadgeController(UserPriceDto userPriceDto) {
        this.userPriceDto = userPriceDto;
    }

    public void createEventBadge() {
        outputView.printEventBadge();
        int totalBenefitsPrice = userPriceDto.getTotalBenefitsPrice();
        PrintUtils.println(Badge.getBadgeName(totalBenefitsPrice));
    }

}
