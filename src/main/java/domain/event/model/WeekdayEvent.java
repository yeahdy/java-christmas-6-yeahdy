package domain.event.model;

import domain.MenuType;
import domain.date.DayType;
import domain.reservation.model.ReservationMenu;
import java.util.List;

public class WeekdayEvent {

    private final int discountPrice;

    public WeekdayEvent(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int selectDiscountPrice(DayType dayType, List<ReservationMenu> menuList){
        if(!DayType.isEventWeekDay(dayType)){
            return 0;
        }

        int desertCount = 0;
        for(ReservationMenu reservationMenu : menuList){
            if(reservationMenu.getMenu().isEventMenuType(MenuType.DESERT)){
                desertCount++;
            }
        }

        return 2023 * desertCount;
    }


}
