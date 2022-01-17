import services.MenuService;

public class Application {

  public static void main(String[] args) throws InterruptedException {
    MenuService menu = new MenuService();
    menu.showInitialMenu();
  }

}
