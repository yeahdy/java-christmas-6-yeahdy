package utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class DateUtils {

    public static final int TWENTY_TWENTY_THREE = 2023;
    public static final int DECEMBER = 12;

    public static LocalDate getLocalDateByNumber(int number){
        return LocalDate.of(TWENTY_TWENTY_THREE, DECEMBER, number);
    }

    public static String getDayByLocalDate(LocalDate date){
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        String day = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.US);
        return day.toUpperCase();
    }
}
