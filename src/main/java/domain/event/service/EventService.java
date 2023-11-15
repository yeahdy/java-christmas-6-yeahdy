package domain.event.service;

import domain.event.model.UserEventGenerator;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import domain.user.UserReceipt;
import domain.user.UserReservation;
import java.util.List;

public class EventService {

    private UserReservation userReservation;
    private UserReceipt userReceipt;
    private EventCalculatorService eventCalculatorService = new EventCalculatorService();
    private UserEventGenerator userEventGenerator = new UserEventGenerator();

    public UserReservation getUserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList){
        int totalPrice = eventCalculatorService.isEventBenefit(menuList);
        userReceipt = new UserReceipt(totalPrice);

        boolean hasEventBenefit = 10000 < totalPrice;
        userReservation = new UserReservation(reservationDate, menuList, hasEventBenefit);
        return userReservation;
    }

    public List<String> selectUserMenuList(List<ReservationMenu> userMenuList){
        return userEventGenerator.getUserMenuList(userMenuList);
    }

    public String selectMenuPrice(){
        return userEventGenerator.getMenuPrice(userReceipt.getPriceBeforeDiscount());
    }

}
