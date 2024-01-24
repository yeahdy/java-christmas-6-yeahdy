package domain.event.service;

import domain.event.model.EventDiscount;
import domain.reservation.model.ReservationMenu;
import domain.user.dto.UserPriceDto;
import java.util.List;

public class EventCalculator {

    /**
     * 할인 전 총주문 금액
     */
    public int getTotalMenuPrice(List<ReservationMenu> reservationMenuList) {
        int totalMenuPrice = 0;
        for (ReservationMenu reservationMenu : reservationMenuList) {
            //FIXME: 예약메뉴 도메인에서 할인 전 총주문금액을 계산하도록 변경
            totalMenuPrice += reservationMenu.getMenu().getPrice() * reservationMenu.getCount();
        }
        return totalMenuPrice;
    }


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
