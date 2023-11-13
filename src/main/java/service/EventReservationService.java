package service;

import domain.ReservationDate;
import utils.PrintUtils;
import view.InputView;
import view.OutputView;

public class EventReservationService {

    private InputView inputView = new InputView();

    private OutputView outputView = new OutputView();

    private ReservationDate reservationDate;

    public void createEventReservation(){
        outputView.printGreeting();
        while (true){
            try{
                int date = inputView.readDate();
                reservationDate = new ReservationDate(date);
                break;
            }catch (IllegalArgumentException iae){
                PrintUtils.errorPrint(iae.getMessage());
            }
        }
    }

}
