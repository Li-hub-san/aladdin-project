package menus;

import helpers.ExceptionHelper;
import helpers.MenuHelper;
import models.Demon;
import models.Genie;
import models.MagicLamp;

import java.util.InputMismatchException;

public class GenieMenu {

    private static boolean keepLooping = true;

    public static void show(Genie chosenGenie, MagicLamp lamp) throws InterruptedException {

        while (keepLooping) {
            printMenu(chosenGenie);

            try {
                handleMenuChoice(chosenGenie, lamp);
            } catch (InputMismatchException exception) {
                ExceptionHelper.handleInputException();
            }
        }
    }

    public static void printMenu(Genie chosenGenie) {
        MenuHelper.printMenuTopLimit("genie menu");
        System.out.println("1 - Make a wish");
        System.out.println("2 - Available wishes");
        System.out.println("3 - Granted wishes");
        if (chosenGenie instanceof Demon) {
            System.out.println("4 - Recharge MagicLamp with Demon");
        }
        System.out.println("0 - Back to Lamp Menu");
        MenuHelper.printMenuBottomLimit();
    }

    public static void handleMenuChoice(Genie chosenGenie, MagicLamp lamp) throws InterruptedException {
        int option = MenuHelper.requestOption();
        switch (option) {
            case 1 -> chosenGenie.grantWish();
            case 2 -> System.out.println("This Genie has " + chosenGenie.getAvailableWishes() + " available wish(es).");
            case 3 -> System.out.println("This Genie has granted " + chosenGenie.getGrantedWishes() + " wish(es).");
            case 4 -> {
                if (chosenGenie instanceof Demon demon) {
                    lamp.recharge(demon);
                    System.out.println("You have recharged this MagicLamp. Mother Nature thanks you!");
                }
            }
            case 0 -> keepLooping = false;
            default -> ExceptionHelper.handleInputException();
        }

    }

}
