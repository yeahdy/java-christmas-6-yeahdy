package domain.user;

import domain.event.model.EventDiscount;

public class UserReceipt {

    private final int priceBeforeDiscount;
    private EventDiscount eventDiscount;
    private int totalBenefitsPrice;
    private int priceAfterDiscount;

    public UserReceipt(int priceBeforeDiscount) {
        this.priceBeforeDiscount = priceBeforeDiscount;
    }

    public int getPriceBeforeDiscount() {
        return priceBeforeDiscount;
    }
}
