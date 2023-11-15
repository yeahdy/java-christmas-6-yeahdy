package domain.event.model;

public class GiftEvent {

    private final int discountPrice;

    public GiftEvent(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int selectDiscountPrice(int price){
        if(price < 120_000){
            return 0;
        }
        return 25_000;
    }


}
