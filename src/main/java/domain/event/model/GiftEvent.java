package domain.event.model;

public class GiftEvent {

    public int selectDiscountPrice(int price) {
        if (price < 120_000) {
            return 0;
        }
        return 25_000;
    }


}
