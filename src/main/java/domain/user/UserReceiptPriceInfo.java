package domain.user;

public class UserReceiptPriceInfo {

    private final int priceBeforeDiscount;  //할인 전 총주문 금액
    private int totalBenefitsPrice; //총 혜택 금액

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
