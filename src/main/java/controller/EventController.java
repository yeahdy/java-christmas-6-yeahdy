package controller;

import domain.event.model.EventDiscount;
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
        createPriceBeforeDiscount();

        EventDiscount eventDiscount = eventService.getTotalEventDiscount();
        createGiftMenu(eventDiscount);
        createBenefitsList(eventDiscount);

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

    private void createPriceBeforeDiscount(){
        outputView.printPriceBeforeDiscount();
        PrintUtils.println(eventService.selectMenuPrice());
        PrintUtils.println("");
    }

    private void createGiftMenu(EventDiscount eventDiscount){
        outputView.printGiftMenu();
        PrintUtils.println(eventService.selectGiftEventDiscountPrice(eventDiscount));
        PrintUtils.println("");
    }

    private void createBenefitsList(EventDiscount eventDiscount){
        outputView.printBenefitsList();
        List<String> benefitsList = eventService.selectBenefitsList(eventDiscount);
        for(String benefit : benefitsList){
            PrintUtils.println(benefit);
        }
        PrintUtils.println("");
    }

    public void createEventBadge(){
        outputView.printEventBadge();
    }

}
