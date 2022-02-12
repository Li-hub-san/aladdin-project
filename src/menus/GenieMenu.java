package menus;

import helpers.ExceptionHelper;
import helpers.MenuHelper;
import models.Demon;
import models.Genie;
import models.MagicLamp;

import java.util.List;
import java.util.Scanner;

public class GenieMenu extends Menu {

    private final MagicLamp lamp;
    private final Genie chosenGenie;

    public GenieMenu(MagicLamp lamp, Genie chosenGenie) {
        this.lamp = lamp;
        this.chosenGenie = chosenGenie;
    }

    @Override
    protected void printMenu() {
        MenuHelper.printTopLimit("genie menu");
        MenuHelper.printTopLimit(chosenGenie.getType(), ".", "");
        System.out.println("1 - Make a wish");
        System.out.println("2 - Available wishes");
        System.out.println("3 - Granted wishes");
        System.out.println("4 - Most popular wishes");
        if (chosenGenie instanceof Demon) {
            System.out.println("5 - Recharge MagicLamp with Demon");
        }
        System.out.println("0 - Back to Lamp Menu");
        MenuHelper.printBottomLimit();
    }

    @Override
    protected void handleMenuChoice() throws InterruptedException {
        int option = MenuHelper.requestOption();
        switch (option) {
            case 1 -> {
                System.out.println("Make a wish: ");
                Scanner sc = new Scanner(System.in);
                String wish = sc.nextLine();
                chosenGenie.grantWish(wish);
            }
            case 2 -> MenuHelper.printOptionResponse("Available wish(es): " + MenuHelper.toSingleCase(chosenGenie.getAvailableWishes()));
            case 3 -> MenuHelper.printOptionResponse("Granted wish(es): " + chosenGenie.getGrantedWishes());
            case 4 -> {
                MenuHelper.printTopLimit("popular wishes", "'");
                List<String> wishes = chosenGenie.getWishes();
                for (String wish : wishes) {
                    System.out.println(wish);
                }
                MenuHelper.printBottomLimit("'");
            }
            case 5 -> {
                if (chosenGenie instanceof Demon demon) {
                    lamp.recharge(demon);
                    MenuHelper.printOptionResponse("You have recharged this MagicLamp. Mother Nature thanks you!");
                    keepLooping = false;
                }
            }
            case 0 -> keepLooping = false;
            default -> ExceptionHelper.handleInputException();
        }
    }
}
