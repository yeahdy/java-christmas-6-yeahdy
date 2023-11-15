package domain.user;

public class UserReceiptPriceInfo {

    private final int priceBeforeDiscount;
    private int totalBenefitsPrice;

    public UserReceiptPriceInfo(int priceBeforeDiscount) {
        this.priceBeforeDiscount = priceBeforeDiscount;
    }

    public int getPriceBeforeDiscount() {
        return priceBeforeDiscount;
    }

    public void setTotalBenefitsPrice(int totalBenefitsPrice) {
        this.totalBenefitsPrice = totalBenefitsPrice;
    }

    public int getTotalBenefitsPrice() {
        return totalBenefitsPrice;
    }

}
