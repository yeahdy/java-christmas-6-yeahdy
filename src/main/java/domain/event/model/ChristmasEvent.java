package domain.event.model;

public class ChristmasEvent{

    public int selectDiscountPrice(int reservedDate){
        if(!isEventByDate(reservedDate)){
            return 0;
        }
        return 1000 + (100 * reservedDate);
    }

    private boolean isEventByDate(int reservedDate){
        if(reservedDate > 25){
            return false;
        }
        return true;
    }

}
