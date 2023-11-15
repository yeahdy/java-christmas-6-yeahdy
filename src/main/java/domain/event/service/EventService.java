package domain.event.service;

import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import domain.user.UserReservation;
import java.util.List;

public class EventService {

    private UserReservation userReservation;
    private EventCalculatorService eventCalculatorService = new EventCalculatorService();

    public UserReservation getUserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList){
        boolean hasEventBenefit = eventCalculatorService.isEventBenefit(menuList);
        userReservation = new UserReservation(reservationDate, menuList, hasEventBenefit);
        return userReservation;
    }

}
