package christmas;

import domain.ReservationDate;
import domain.ReservationMenu;
import java.util.List;
import service.ReservationController;

public class ChristmasEventApplication {

    private ReservationController reservationController = new ReservationController();

    public void run(){
        ReservationDate reservationDate = reservationController.createReservationDate();
        List<ReservationMenu> reservationMenuList = reservationController.createReservationMenu();
    }


}
