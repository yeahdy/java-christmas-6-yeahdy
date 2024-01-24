package domain.reservation.model;

import domain.menu.Menu;

public class ReservationMenu {

    private Menu menu;
    private int count;

     public int calculateMenuPrice(){
         return menu.getPrice() * count;
     }

    public ReservationMenu(Menu menu, int count) {
        this.menu = menu;
        this.count = count;
    }

    // 사용자가 예약한 메뉴 타입에 따라 주문한 메뉴 갯수만큼 할인받을 수 있다.
    public Menu getMenu() {
        return menu;
    }

    public int getCount() {
        return count;
    }
}
