package domain.event.service;

import domain.event.model.EventGenerator;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import domain.user.UserReceipt;
import domain.user.UserReservation;
import java.util.List;

public class EventService {

    private UserReservation userReservation;
    private UserReceipt userReceipt;
    private EventCalculatorService eventCalculatorService = new EventCalculatorService();
    private EventGenerator eventGenerator = new EventGenerator();

    public UserReservation getUserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList){
        int totalPrice = eventCalculatorService.isEventBenefit(menuList);
        userReceipt = new UserReceipt(totalPrice);

        boolean hasEventBenefit = 10000 < totalPrice;
        userReservation = new UserReservation(reservationDate, menuList, hasEventBenefit);
        return userReservation;
    }

    public List<String> selectUserMenuList(List<ReservationMenu> userMenuList){
        return eventGenerator.getUserMenuList(userMenuList);
    }

    public String selectMenuPrice(){
        return eventGenerator.getMenuPrice(userReceipt.getPriceBeforeDiscount());
    }

}
