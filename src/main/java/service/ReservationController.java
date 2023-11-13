package service;

import domain.ReservationDate;
import domain.ReservationMenu;
import java.util.List;
import utils.PrintUtils;
import view.InputView;
import view.OutputView;

public class ReservationController {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private ReservationMenuService reservationMenuService = new ReservationMenuService();

    public ReservationDate createReservationDate(){
        outputView.printGreeting();
        while (true){
            try{
                int date = inputView.readDate();
                return new ReservationDate(date);
            }catch (IllegalArgumentException iae){
                PrintUtils.errorPrint(iae.getMessage());
            }
        }
    }


    public List<ReservationMenu> createReservationMenu(){
        while (true){
            try{
                String order = inputView.readOrder();
                String[] orderList = reservationMenuService.validateOrderList(order);

                return reservationMenuService.validateReservationMenu(orderList);
            }catch (IllegalArgumentException iae){
                PrintUtils.errorPrint(iae.getMessage());
            }
        } //while
    }

}
