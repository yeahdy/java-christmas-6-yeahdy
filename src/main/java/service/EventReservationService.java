package service;

import domain.EventReservation;
import utils.PrintUtils;
import view.InputView;
import view.OutputView;

public class EventReservationService {

    private InputView inputView = new InputView();

    private OutputView outputView = new OutputView();

    private EventReservation eventReservation;

    public void createEventReservation(){
        outputView.printGreeting();
        while (true){
            try{
                int date = inputView.readDate();
                eventReservation = new EventReservation(date);
                break;
            }catch (IllegalArgumentException iae){
                PrintUtils.println(iae.getMessage());
            }
        }
    }

}
