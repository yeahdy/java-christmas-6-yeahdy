package christmas;

import controller.BadgeController;
import controller.EventController;
import domain.reservation.service.ReservationMenuService;
import domain.user.service.UserReservationService;
import controller.ReservationController;

public class ChristmasEventApplication {

    private EventController eventController = new EventController();
    private BadgeController badgeController;
    public void run() {
        ReservationController reservationController = new ReservationController(new ReservationMenuService(), new UserReservationService());
        reservationController.createUserReservation();
        //eventController.createEventList();
        badgeController = new BadgeController(eventController.createUserReceiptPriceInfo());
        badgeController.createEventBadge();
    }


}
