import models.Demon;
import models.MagicLamp;

public class Application {

    public static void main(String[] args) throws InterruptedException {
        MagicLamp lamp = new MagicLamp(1);
        Demon demon = new Demon(1);
        Demon demon1 = new Demon(1);
        lamp.recharge(demon);
        lamp.recharge(demon1);
        System.out.println(lamp.getRechargeCounter());
        demon.grantWish();

//        MenuService menu = new MenuService();
//        menu.showInitialMenu();
    }

}
