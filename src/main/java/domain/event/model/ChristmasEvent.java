package domain.event.model;

public class ChristmasEvent implements Event{

    @Override
    public int selectEventResult(int reservedDate){
        if(!isEventByDate(reservedDate)){
            return 0;
        }
        return 1000 + (100 * reservedDate);
    }

    public boolean isEventByDate(int reservedDate){
        if(reservedDate > 25){
            return false;
        }
        return true;
    }

}
