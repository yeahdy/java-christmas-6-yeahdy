package controller;

import domain.event.service.EventService;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import domain.user.UserReservation;
import java.util.List;
import utils.PrintUtils;
import view.InputView;
import view.OutputView;

public class EventController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private UserReservation userReservation;
    private EventService eventService = new EventService();

    public void createUserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList){
        userReservation = eventService.getUserReservation(reservationDate,menuList);
    }

    public void createEventList(){
        outputView.printCheckBenefit(String.valueOf(userReservation.getReservedDate()));

        createOrderMenu();

        outputView.printPriceBeforeDiscount();

        outputView.printGiftMenu();

        outputView.printBenefitsList();

        outputView.printTotalBenefitsPrice();

        outputView.printPriceAfterDiscount();

    }

    private void createOrderMenu(){
        outputView.printOrderMenu();
        List<String> userMenuList = eventService.selectUserMenuList(userReservation.getMenuList());
        for(String userMenu : userMenuList){
            PrintUtils.println(userMenu);
        }
        PrintUtils.println("");
    }

    public void createEventBadge(){
        outputView.printEventBadge();
    }

}
