package domain.user.model;

import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import java.util.List;

public class UserReservation {

    private final ReservationDate reservationDate;
    private final List<ReservationMenu> menuList;
    private final boolean hasEventBenefit;
    private final int priceBeforeDiscount;

    public UserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList, int priceBeforeDiscount, boolean hasEventBenefit) {
        this.reservationDate = reservationDate;
        this.menuList = menuList;
        this.priceBeforeDiscount = priceBeforeDiscount;
        this.hasEventBenefit = hasEventBenefit;
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
