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
import view.ViewFactory;

public class ChristmasEventApplication {

    private ViewFactory viewFactory;
    private EventGenerator eventGenerator;

    public ChristmasEventApplication(ViewFactory viewFactory, EventGenerator eventGenerator) {
        this.viewFactory = viewFactory;
        this.eventGenerator = eventGenerator;
    }

    public void run() {
        InputView inputView = viewFactory.getInputView();
        OutputView outputView = viewFactory.getOutputView();

        ReservationController reservationController = new ReservationController(
                inputView, outputView, new ReservationMenuService(), new UserReservationService(eventGenerator));
        reservationController.createUserReservation();

        EventController eventController = new EventController(
                outputView, reservationController.userReservation, new EventService(eventGenerator, new EventFacade()));
        eventController.createEventList();

        BadgeController badgeController = new BadgeController(outputView, eventController.userPriceDto);
        badgeController.createEventBadge();
    }


}
