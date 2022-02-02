import models.*;
import services.MenuService;

public class Application {

    public static void main(String[] args) throws InterruptedException {

    MenuService menu = new MenuService();
    menu.showInitialMenu();
//
//    lamp1.rub(5); //1 -> 0
//    lamp1.rub(9); //2 -> 1
//    lamp1.rub(3); //3 -> 2
//    lamp1.rub(1); //4 -> 3
//
//    lamp1.recharge(new Demon(2));
//    System.out.println(lamp1.getAvailableGenies());
//    System.out.println(lamp1.getRechargeCounter());
//
//    Genie genie1 = new Genie(5) {
//      @Override
//      protected String getType() {
//        String GrumpyGenie = String.valueOf(new GrumpyGenie(5));
//        return GrumpyGenie;
//      }
//    };
    }

}
