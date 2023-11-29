package controller;

import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import domain.user.model.UserReservation;
import domain.user.service.UserReservationService;
import java.util.List;
import domain.reservation.service.ReservationMenuService;
import utils.PrintUtils;
import view.InputView;
import view.OutputView;

public class ReservationController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ReservationMenuService reservationMenuService;
    private UserReservationService userReservationService;
    private UserReservation userReservation;

    public ReservationController(ReservationMenuService reservationMenuService, UserReservationService userReservationService){
        this.reservationMenuService = reservationMenuService;
        this.userReservationService = userReservationService;
    }

    public void createUserReservation() {
        ReservationDate reservationDate =createReservationDate();
        List<ReservationMenu> menuList = createReservationMenu();
        userReservation = userReservationService.getUserReservation(reservationDate, menuList);
        selectUserReservation();
    }

    public ReservationDate createReservationDate() {
        outputView.printGreeting();
        while (true) {
            try {
                int date = inputView.readDate();
                return new ReservationDate(date);
            } catch (IllegalArgumentException iae) {
                PrintUtils.errorPrint(iae.getMessage());
            }
        }
    }


    public List<ReservationMenu> createReservationMenu() {
        while (true) {
            try {
                String order = inputView.readOrder();
                String[] orderList = reservationMenuService.validateOrderList(order);

                return reservationMenuService.validateReservationMenu(orderList);
            } catch (IllegalArgumentException iae) {
                PrintUtils.errorPrint(iae.getMessage());
            }
        } //while
    }

    private void selectUserReservation() {
        outputView.printCheckBenefit(String.valueOf(userReservation.getReservedDate()));
        outputView.printOrderMenu();
        List<String> userMenuList = userReservationService.selectUserMenuList(userReservation.getMenuList());
        for (String userMenu : userMenuList) {
            PrintUtils.println(userMenu);
        }
        PrintUtils.println("");
    }

}
