package domain.user;

import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import java.util.List;

public class UserReservation {

    private final ReservationDate reservationDate;
    private final List<ReservationMenu> menuList;
    private final boolean hasEventBenefit;

    public UserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList, boolean hasEventBenefit){
        this.reservationDate = reservationDate;
        this.menuList = menuList;
        this.hasEventBenefit = hasEventBenefit;
    }

    public int getReservedDate(){
        return reservationDate.getReservedDate();
    }

    public List<ReservationMenu> getMenuList() {
        return menuList;
    }
}
