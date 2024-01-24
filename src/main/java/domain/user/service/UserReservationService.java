package domain.user.service;

import domain.event.service.EventGenerator;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import java.util.List;

public class UserReservationService {

    private EventGenerator eventGenerator;

    public UserReservationService(EventGenerator eventGenerator) {
        this.eventGenerator = eventGenerator;
    }

    public String getUserReservedDate(ReservationDate reservationDate) {
        return String.valueOf(reservationDate.getReservedDate());
    }

    public List<String> selectUserMenuList(List<ReservationMenu> userMenuList) {
        return eventGenerator.getUserMenuList(userMenuList);
    }

}
