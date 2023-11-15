package domain.user;

public class UserReceipt {

    private final int priceBeforeDiscount;
    private int totalBenefitsPrice;
    private int priceAfterDiscount;

    public UserReceipt(int priceBeforeDiscount){
        this.priceBeforeDiscount = priceBeforeDiscount;
    }

    public int getPriceBeforeDiscount() {
        return priceBeforeDiscount;
    }
}
