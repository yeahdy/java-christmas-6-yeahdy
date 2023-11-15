package domain.event.service;

import domain.Menu;
import domain.event.model.EventCalculator;
import domain.reservation.model.ReservationMenu;
import java.util.ArrayList;
import java.util.List;

public class EventCalculatorService {

    private EventCalculator eventCalculator = new EventCalculator();

    public boolean isEventBenefit(List<ReservationMenu> reservationMenuList){
        List<Menu> menuList = new ArrayList<>();

        for(ReservationMenu reservationMenu : reservationMenuList){
            menuList.add(reservationMenu.getMenu());
        }

        int totalPrice = eventCalculator.getTotalMenuPrice(menuList);
        return 10000 < totalPrice;
    }

}
