package service;

import domain.ReservationDate;
import domain.ReservationMenu;
import utils.PrintUtils;
import view.InputView;
import view.OutputView;

public class EventReservationService {

    private InputView inputView = new InputView();

    private OutputView outputView = new OutputView();

    private ReservationDate reservationDate;
    private ReservationMenu reservationMenu;

    public void createReservationDate(){
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


    public void createReservationMenu(){
        while (true){
            try{
                String order = inputView.readOrder();
                reservationMenu = new ReservationMenu();
                String[] orderList = reservationMenu.validateOrder(order);
                break;
            }catch (IllegalArgumentException iae){
                PrintUtils.errorPrint(iae.getMessage());
            }
        }

    }

}
