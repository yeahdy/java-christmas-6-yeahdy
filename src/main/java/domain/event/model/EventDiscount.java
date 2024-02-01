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

    /**
     * 총혜택 금액
     */
    public int getTotalBenefitsPrice() {
        //NOTE: EventDiscount에게 총 할인금액을 계산하는 역할을 주고, 외부에서 해당 메세지를 사용하도록 변경
        int totalBenefitsPrice = 0;
        totalBenefitsPrice += christmasPrice;
        totalBenefitsPrice += weekdayPrice;
        totalBenefitsPrice += weekendPrice;
        totalBenefitsPrice += specialPrice;
        totalBenefitsPrice += giftPrice;
        return totalBenefitsPrice;
    }

    /**
     * 할인 후 예상 결제 금액
     */
    //NOTE: 굳이 이벤트계산(EventCalculator)을 분리해서 불필요한 의존성을 만들었음
    // 이벤트 할인을 위한 정보를 가장많이 알고 있는 객체에게 역할을 부여해서 메세지를 전달하도록 변경
    // getGiftPrice() > this.giftPrice
    public int getPriceAfterDiscount(int totalBenefitsPrice, int priceBeforeDiscount){
        return priceBeforeDiscount - (totalBenefitsPrice - this.giftPrice);
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
