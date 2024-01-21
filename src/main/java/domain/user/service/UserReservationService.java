package domain.user.service;

import domain.event.service.EventCalculator;
import domain.event.service.EventGenerator;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import domain.user.model.UserReservation;
import java.util.List;

public class UserReservationService {

    private EventCalculator eventCalculator;
    private EventGenerator eventGenerator;

    public UserReservationService(EventCalculator eventCalculator, EventGenerator eventGenerator) {
        this.eventCalculator = eventCalculator;
        this.eventGenerator = eventGenerator;
    }

    public String getUserReservedDate(ReservationDate reservationDate) {
        return String.valueOf(reservationDate.getReservedDate());
    }

    public UserReservation getUserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList) {
        int totalPrice = eventCalculator.getTotalMenuPrice(menuList);
        boolean hasEventBenefit = 10000 < totalPrice;
        return new UserReservation(reservationDate, menuList, totalPrice, hasEventBenefit);
    }

    public List<String> selectUserMenuList(List<ReservationMenu> userMenuList) {
        return eventGenerator.getUserMenuList(userMenuList);
    }

}
