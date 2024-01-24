package domain.user.model;

import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import java.util.List;

public class UserReservation {

    private final ReservationDate reservationDate;
    private final List<ReservationMenu> menuList;
    private final boolean hasEventBenefit;
    private final int priceBeforeDiscount;

    public UserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList) {
        this.reservationDate = reservationDate;
        this.menuList = menuList;
        this.priceBeforeDiscount = getTotalMenuPrice(menuList);
        this.hasEventBenefit = 10_000 < priceBeforeDiscount;
    }

    /**
     * 할인 전 총주문 금액
     */
    //FIXME: UserReservation 도메인에서 할인 전 총주문금액을 계산하도록 변경
    private int getTotalMenuPrice(List<ReservationMenu> menuList) {
        int totalMenuPrice = 0;
        for (ReservationMenu reservationMenu : menuList) {
            //FIXME: 예약메뉴가 직접 메뉴 갯수만큼 금액을 계산하도록 역할 주기
            totalMenuPrice += reservationMenu.calculateMenuPrice();
        }
        return totalMenuPrice;
    }


    public ReservationDate getReservationDate() {
        return reservationDate;
    }

    public List<ReservationMenu> getMenuList() {
        return menuList;
    }

    public boolean isHasEventBenefit() {
        return hasEventBenefit;
    }

    public int getPriceBeforeDiscount() {
        return priceBeforeDiscount;
    }
}
