package domain.event.service;

import domain.event.model.EventGenerator;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import domain.user.UserReservation;
import java.util.List;

public class EventService {

    private UserReservation userReservation;
    private EventCalculatorService eventCalculatorService = new EventCalculatorService();
    private EventGenerator eventGenerator = new EventGenerator();

    public UserReservation getUserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList){
        boolean hasEventBenefit = eventCalculatorService.isEventBenefit(menuList);
        userReservation = new UserReservation(reservationDate, menuList, hasEventBenefit);
        return userReservation;
    }

    public List<String> selectUserMenuList(List<ReservationMenu> userMenuList){
        return eventGenerator.getUserMenuList(userMenuList);
    }

}
