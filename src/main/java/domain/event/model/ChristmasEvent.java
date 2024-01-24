package domain.event.model;

public class ChristmasEvent extends Event{

    private int reservedDate;

    public ChristmasEvent(int reservedDate) {
        this.reservedDate = reservedDate;
    }

    @Override
    public int selectDiscountPrice() {
        if (!isEventByDate(reservedDate)) {
            return 0;
        }
        return 100 * (reservedDate - 1) + 1000;
    }


    private boolean isEventByDate(int reservedDate) {
        if (reservedDate > 25) {
            return false;
        }
        return true;
    }

}
