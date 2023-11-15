package domain.event.model;

public class ChristmasEvent{

    public int selectDiscountPrice(int reservedDate){
        if(!isEventByDate(reservedDate)){
            return 0;
        }
        return 100 * (reservedDate-1) + 1000;
    }

    private boolean isEventByDate(int reservedDate){
        if(reservedDate > 25){
            return false;
        }
        return true;
    }

}
