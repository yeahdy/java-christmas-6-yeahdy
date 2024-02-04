package christmas;

import domain.event.service.EventGenerator;
import view.ViewFactory;

public class Application {
    public static void main(String[] args) {
        ChristmasEventApplication christmasEventApplication = new ChristmasEventApplication(new ViewFactory(), new EventGenerator());
        christmasEventApplication.run();
    }
}
