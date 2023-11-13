package domain.reservation.model;

import java.util.List;

public class UserReservation {

    private final ReservationDate reservationDate;
    private final List<ReservationMenu> menuList;

    public UserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList){
        this.reservationDate = reservationDate;
        this.menuList = menuList;
    }

}
