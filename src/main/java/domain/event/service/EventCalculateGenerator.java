package domain.event.service;

import domain.event.model.EventCalculator;
import domain.event.model.EventDiscount;
import domain.reservation.model.ReservationMenu;
import java.util.List;

public class EventCalculateGenerator {

    private EventCalculator eventCalculator = new EventCalculator();

    public int getTotalMenuPrice(List<ReservationMenu> reservationMenuList){
        int totalMenuPrice = 0;
        for(ReservationMenu reservationMenu : reservationMenuList){
            totalMenuPrice += eventCalculator.getTotalMenuPrice(reservationMenu);
        }
        return totalMenuPrice;
    }

    public int getTotalBenefitsPrice(EventDiscount eventDiscount){
        return eventCalculator.getTotalBenefitsPrice(eventDiscount);
    }

}
