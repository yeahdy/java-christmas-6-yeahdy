package controller;

import domain.event.model.EventDiscount;
import domain.event.service.EventService;
import domain.user.dto.UserPriceDto;
import domain.user.model.UserReservation;
import java.util.List;
import utils.PrintUtils;
import view.OutputView;

public class EventController {

    private OutputView outputView;
    private EventService eventService;
    private UserReservation userReservation;
    public UserPriceDto userPriceDto;

    public EventController(OutputView outputView, UserReservation userReservation, EventService eventService) {
        this.outputView = outputView;
        this.userReservation = userReservation;
        this.eventService = eventService;
    }

    public void createEventList() {
        int priceBeforeDiscount = userReservation.getPriceBeforeDiscount();
        createPriceBeforeDiscount(priceBeforeDiscount);
        EventDiscount eventDiscount = isEventDiscount(userReservation);
        createGiftMenu(eventDiscount);
        createBenefitsList(eventDiscount);
        createTotalBenefitsPrice(eventDiscount, priceBeforeDiscount);
        createPriceAfterDiscount(userPriceDto, eventDiscount);
    }

    private void createPriceBeforeDiscount(int priceBeforeDiscount) {
        outputView.printPriceBeforeDiscount();
        PrintUtils.println(eventService.selectMenuPrice(priceBeforeDiscount));
        PrintUtils.println("");
    }

    private EventDiscount isEventDiscount(UserReservation userReservation) {
        if (!userReservation.isHasEventBenefit()) {
            return null;
        }
        return eventService.getTotalEventDiscount(userReservation.getReservationDate(), userReservation.getMenuList(),
                userReservation.getPriceBeforeDiscount());
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

    private void createTotalBenefitsPrice(EventDiscount eventDiscount, int priceBeforeDiscount) {
        outputView.printTotalBenefitsPrice();
        if (eventDiscount == null) {
            PrintUtils.println("없음");
            PrintUtils.println("");
            return;
        }
        userPriceDto = eventService.selectTotalBenefitsPrice(eventDiscount, priceBeforeDiscount);
        PrintUtils.println(eventService.selectTotalBenefitsPrice(priceBeforeDiscount));
        PrintUtils.println("");
    }

    private void createPriceAfterDiscount(UserPriceDto userPriceDto, EventDiscount eventDiscount) {
        outputView.printPriceAfterDiscount();
        PrintUtils.println(eventService.selectPriceAfterDiscount(userPriceDto, eventDiscount));
        PrintUtils.println("");
    }

}
