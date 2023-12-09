package domain.user.service;

import domain.event.service.EventCalculateGenerator;
import domain.event.service.EventGenerator;
import domain.reservation.model.ReservationDate;
import domain.reservation.model.ReservationMenu;
import domain.user.dto.UserPriceDto;
import domain.user.model.UserReservation;
import java.util.List;

public class UserReservationService {

    private UserReservation userReservation;
    private UserPriceDto userPriceDto;

    private EventCalculateGenerator eventCalculateGenerator = new EventCalculateGenerator();
    private EventGenerator eventGenerator = new EventGenerator();

    public String getUserReservedDate(ReservationDate reservationDate){
        return String.valueOf(reservationDate.getReservedDate());
    }

    public UserReservation getUserReservation(ReservationDate reservationDate, List<ReservationMenu> menuList) {
        int totalPrice = eventCalculateGenerator.getTotalMenuPrice(menuList);
        userPriceDto = new UserPriceDto(totalPrice);

        boolean hasEventBenefit = 10000 < totalPrice;
        userReservation = new UserReservation(reservationDate, menuList, hasEventBenefit);
        return userReservation;
    }

    public List<String> selectUserMenuList(List<ReservationMenu> userMenuList) {
        return eventGenerator.getUserMenuList(userMenuList);
    }

}
