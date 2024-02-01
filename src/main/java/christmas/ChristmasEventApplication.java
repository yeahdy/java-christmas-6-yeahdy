package christmas;

import controller.BadgeController;
import controller.EventController;
import domain.event.service.EventFacade;
import domain.event.service.EventGenerator;
import domain.event.service.EventService;
import domain.reservation.service.ReservationMenuService;
import domain.user.service.UserReservationService;
import controller.ReservationController;
import view.InputView;
import view.OutputView;

public class ChristmasEventApplication {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private EventGenerator eventGenerator = new EventGenerator();

    public void run() {
        ReservationController reservationController = new ReservationController(inputView, outputView,
                new ReservationMenuService(),
                new UserReservationService(eventGenerator));
        reservationController.createUserReservation();

        EventController eventController = new EventController(
                outputView, reservationController.userReservation, new EventService(eventGenerator, new EventFacade()));
        eventController.createEventList();

        BadgeController badgeController = new BadgeController(outputView, eventController.userPriceDto);
        badgeController.createEventBadge();
    }


}
