package domain.date;

import constants.ErrorCodeConstant;
import java.time.LocalDate;
import utils.DateUtils;

public enum DayType {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static DayType getDayTypeByLocalDate(LocalDate date) {
        String dayName = DateUtils.getDayByLocalDate(date);

        for (DayType dayType : values()) {
            if (dayType.toString().equals(dayName)) {
                return dayType;
            }
        }
        throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_DATE_ERROR);
    }

    public static boolean isEventWeekDay(DayType dayType){
        if(dayType.equals(FRIDAY) || dayType.equals(SATURDAY)){
            return false;
        }
        return true;
    }

}
