package domain.user.dto;

public class UserPriceDto {

    private final int priceBeforeDiscount;  //할인 전 총주문 금액
    private final int totalBenefitsPrice;   //총 혜택 금액

    public UserPriceDto(int priceBeforeDiscount, int totalBenefitsPrice) {
        this.priceBeforeDiscount = priceBeforeDiscount;
        this.totalBenefitsPrice = totalBenefitsPrice;
    }

    public int getPriceBeforeDiscount() {
        return priceBeforeDiscount;
    }

    public int getTotalBenefitsPrice() {
        return totalBenefitsPrice;
    }

}
