package christmas;

import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import java.util.List;
import controller.ReservationController;

public class ChristmasEventApplication {

    private ReservationController reservationController = new ReservationController();

    public void run(){
        ReservationDate reservationDate = reservationController.createReservationDate();
        List<ReservationMenu> reservationMenuList = reservationController.createReservationMenu();
    }


}
