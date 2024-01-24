package domain.event.model;

import domain.menu.MenuType;
import domain.date.DayType;
import domain.reservation.model.ReservationMenu;
import java.util.List;

public class WeekdayEvent extends Event{

    private DayType dayType;
    private List<ReservationMenu> menuList;

    public WeekdayEvent(DayType dayType, List<ReservationMenu> menuList) {
        this.dayType = dayType;
        this.menuList = menuList;
    }

    @Override
    public int selectDiscountPrice() {
        if (!DayType.isEventWeekDay(dayType)) {
            return 0;
        }

        int desertCount = 0;
        for (ReservationMenu reservationMenu : menuList) {
            if (reservationMenu.getMenu().isEventMenuType(MenuType.DESERT)) {
                desertCount += reservationMenu.getCount();
            }
        }

        return 2023 * desertCount;
    }

}
