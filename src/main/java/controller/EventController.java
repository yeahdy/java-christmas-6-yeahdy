package controller;

import domain.event.model.EventDiscount;
import domain.event.service.EventService;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import dto.UserPriceDto;
import domain.user.UserReservation;
import java.util.List;
import utils.PrintUtils;
import view.OutputView;

public class EventController {

    private OutputView outputView = new OutputView();
    private UserReservation userReservation;
    private EventService eventService = new EventService();

    public void createUserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList) {
        userReservation = eventService.getUserReservation(reservationDate, menuList);
    }

    public void createEventList() {
        outputView.printCheckBenefit(String.valueOf(userReservation.getReservedDate()));
        createOrderMenu();
        createPriceBeforeDiscount();

        EventDiscount eventDiscount = eventService.getTotalEventDiscount();
        createGiftMenu(eventDiscount);
        createBenefitsList(eventDiscount);
        createTotalBenefitsPrice(eventDiscount);
        createPriceAfterDiscount(eventDiscount);
    }

    private void createOrderMenu() {
        outputView.printOrderMenu();
        List<String> userMenuList = eventService.selectUserMenuList(userReservation.getMenuList());
        for (String userMenu : userMenuList) {
            PrintUtils.println(userMenu);
        }
        PrintUtils.println("");
    }

    private void createPriceBeforeDiscount() {
        outputView.printPriceBeforeDiscount();
        PrintUtils.println(eventService.selectMenuPrice());
        PrintUtils.println("");
    }

    private void createGiftMenu(EventDiscount eventDiscount) {
        outputView.printGiftMenu();
        PrintUtils.println(eventService.selectGiftEventDiscountPrice(eventDiscount));
        PrintUtils.println("");
    }

    private void createBenefitsList(EventDiscount eventDiscount) {
        outputView.printBenefitsList();
        List<String> benefitsList = eventService.selectBenefitsList(eventDiscount);
        for (String benefit : benefitsList) {
            PrintUtils.println(benefit);
        }
        PrintUtils.println("");
    }

    private void createTotalBenefitsPrice(EventDiscount eventDiscount) {
        outputView.printTotalBenefitsPrice();
        PrintUtils.println(eventService.selectTotalBenefitsPrice(eventDiscount));
        PrintUtils.println("");
    }

    private void createPriceAfterDiscount(EventDiscount eventDiscount) {
        outputView.printPriceAfterDiscount();
        PrintUtils.println(eventService.selectPriceAfterDiscount(eventDiscount));
        PrintUtils.println("");
    }

    public UserPriceDto createUserReceiptPriceInfo() {
        return eventService.selectUserReservation();
    }

}
