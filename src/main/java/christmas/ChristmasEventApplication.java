package christmas;

import controller.BadgeController;
import controller.EventController;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import java.util.List;
import controller.ReservationController;

public class ChristmasEventApplication {

    private ReservationController reservationController = new ReservationController();
    private EventController eventController = new EventController();
    private BadgeController badgeController = new BadgeController();

    public void run() {
        ReservationDate reservationDate = reservationController.createReservationDate();
        List<ReservationMenu> reservationMenuList = reservationController.createReservationMenu();
        eventController.createUserReservation(reservationDate, reservationMenuList);
        eventController.createEventList();
        badgeController.createEventBadge();
    }


}
