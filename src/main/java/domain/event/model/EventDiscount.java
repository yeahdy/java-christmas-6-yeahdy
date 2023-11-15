package domain.event.model;

public class EventDiscount {

    private final int christmasPrice;
    private final int weekdayPrice;
    private final int weekendPrice;
    private final int specialPrice;
    private final int giftPrice;

    public EventDiscount(int christmasPrice, int weekdayPrice, int weekendPrice, int specialPrice, int giftPrice) {
        this.christmasPrice = christmasPrice;
        this.weekdayPrice = weekdayPrice;
        this.weekendPrice = weekendPrice;
        this.specialPrice = specialPrice;
        this.giftPrice = giftPrice;
    }

    public int getChristmasPrice() {
        return christmasPrice;
    }

    public int getWeekdayPrice() {
        return weekdayPrice;
    }

    public int getWeekendPrice() {
        return weekendPrice;
    }

    public int getSpecialPrice() {
        return specialPrice;
    }

    public int getGiftPrice() {
        return giftPrice;
    }
}
