package constants;

public enum DayType {

    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;

    public static DayType getDayTypeByString(String dayName) {
        for (DayType dayType : values()) {
            if (dayType.toString().equals(dayName)) {
                return dayType;
            }
        }
        throw new IllegalArgumentException(ErrorCodeConstant.NOT_VALID_DATE_ERROR);
    }


}
