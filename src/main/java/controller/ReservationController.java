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

    private InputView inputView;
    private OutputView outputView;
    private ReservationMenuService reservationMenuService;
    private UserReservationService userReservationService;
    public UserReservation userReservation;

    public ReservationController(InputView inputView, OutputView outputView,
                                 ReservationMenuService reservationMenuService,
                                 UserReservationService userReservationService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.reservationMenuService = reservationMenuService;
        this.userReservationService = userReservationService;
    }

    public void createUserReservation() {
        ReservationDate reservationDate = createReservationDate();
        List<ReservationMenu> menuList = createReservationMenu();
        selectUserReservation(reservationDate, menuList);
        userReservation = new UserReservation(reservationDate, menuList);
    }

    private ReservationDate createReservationDate() {
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


    private List<ReservationMenu> createReservationMenu() {
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

    private void selectUserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList) {
        outputView.printCheckBenefit(userReservationService.getUserReservedDate(reservationDate));
        outputView.printOrderMenu();
        List<String> userMenuList = userReservationService.selectUserMenuList(menuList);
        for (String userMenu : userMenuList) {
            PrintUtils.println(userMenu);
        }
        PrintUtils.println("");
    }

}
