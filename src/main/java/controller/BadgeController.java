package controller;

import view.OutputView;

public class BadgeController {

    private OutputView outputView = new OutputView();

    public void createEventBadge() {
        outputView.printEventBadge();
    }

}
