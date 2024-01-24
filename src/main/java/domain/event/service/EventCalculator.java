package domain.event.service;

import domain.user.dto.UserPriceDto;

public class EventCalculator {

    /**
     * 할인 후 예상 결제 금액
     */
    //FIXME: 굳이 이벤트계산 파일을 분리해서 불필요한 의존성을 만들고 있음.
    // 해당 메소드를 호출한 메소드(EventService파일)로 코드 옮기기
    public int getPriceAfterDiscount(UserPriceDto userPriceDto, int giftPrice) {
        int totalEventPrice = userPriceDto.getTotalBenefitsPrice() - giftPrice;
        return userPriceDto.getPriceBeforeDiscount() - totalEventPrice;
    }

}
