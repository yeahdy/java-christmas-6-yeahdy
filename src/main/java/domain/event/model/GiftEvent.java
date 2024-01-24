package domain.event.model;

public class GiftEvent implements Event{

    private int priceBeforeDiscount;

    public GiftEvent(int priceBeforeDiscount) {
        this.priceBeforeDiscount = priceBeforeDiscount;
    }

    @Override
    public int selectDiscountPrice() {
        if (priceBeforeDiscount < 120_000) {
            return 0;
        }
        return 25_000;
    }

}
