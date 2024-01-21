package controller;

import domain.badge.Badge;
import domain.user.dto.UserPriceDto;
import utils.PrintUtils;
import view.OutputView;

public class BadgeController {

    private OutputView outputView;
    private UserPriceDto userPriceDto;

    public BadgeController(OutputView outputView, UserPriceDto userPriceDto) {
        this.outputView = outputView;
        this.userPriceDto = userPriceDto;
    }

    public void createEventBadge() {
        outputView.printEventBadge();
        int totalBenefitsPrice = userPriceDto.getTotalBenefitsPrice();
        PrintUtils.println(Badge.getBadgeName(totalBenefitsPrice));
    }

}
