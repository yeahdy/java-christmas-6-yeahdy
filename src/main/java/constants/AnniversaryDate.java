package constants;

import static constants.DayType.MONDAY;

import java.time.LocalDate;

public enum AnniversaryDate {

    CHRISTMAS(LocalDate.of(2023,12,25),MONDAY);

    private LocalDate localDate;
    private DayType dayType;

    AnniversaryDate(LocalDate localDate, DayType dayType){
        this.localDate = localDate;
        this.dayType = dayType;
    }

    public static DayType getAnniversaryDayType(LocalDate localDate){
        for(AnniversaryDate anniversaryDate : values()){
            if(anniversaryDate.localDate.equals(localDate)){
                return anniversaryDate.dayType;
            }
        }
        return null;
    }

}
