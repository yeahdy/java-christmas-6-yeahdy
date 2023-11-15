package domain.event.model;

import domain.MenuType;
import domain.date.DayType;
import domain.reservation.model.ReservationMenu;
import java.util.List;

public class WeekendEvent {

    public int selectEventResult(DayType dayType, List<ReservationMenu> menuList){
        if(DayType.isEventWeekDay(dayType)){
            return 0;
        }

        int mainCount = 0;
        for(ReservationMenu reservationMenu : menuList){
            if(reservationMenu.getMenu().isEventMenuType(MenuType.MAIN)){
                mainCount++;
            }
        }

        return 2023 * mainCount;
    }


}