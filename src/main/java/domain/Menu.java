package domain;

import static domain.MenuType.APPETIZER;
import static domain.MenuType.DESERT;
import static domain.MenuType.DRINK;
import static domain.MenuType.MAIN;

public enum Menu {

    MUSHROOM_SOUP(APPETIZER,"양송이수프",6000),
    TAPAS(APPETIZER,"타파스",5500),
    CAESAR_SALAD(APPETIZER,"시저샐러드",8000),
    T_BONE_STEAK(MAIN,"티본스테이크",55000),
    BBQ_RIBS(MAIN,"바비큐립",54000),
    SEAFOOD_PASTA(MAIN,"해산물파스타",35000),
    CHRISTMAS_PASTA(MAIN,"크리스마스파스타",25000),
    CHOCOLATE_CAKE(DESERT,"초코케이크",15000),
    ICE_CREAM(DESERT,"아이스크림",5000),
    ZERO_COKE(DRINK,"제로콜라",3000),
    RED_WINE(DRINK,"레드와인",60000),
    CHAMPAGNE(DRINK,"샴페인",25000);

    private MenuType menuType;
    private String food;
    private int price;

    Menu(MenuType menuType, String food, int price){
        this.menuType = menuType;
        this.food = food;
        this.price = price;
    }

    public static Menu getMenu(String food){
        for(Menu menu : values()){
            if(menu.food.equals(food)){
                return menu;
            }
        }
        return null;
    }

    public static MenuType getMenuType(String food){
        for(Menu menu : values()){
            if(menu.food.equals(food)){
                return menu.menuType;
            }
        }
        return null;
    }

    public String getFood() {
        return food;
    }

    public int getPrice() {
        return price;
    }
}