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

        // Declared to false in handleMenuChoice();
        // Needs to be reset, or it never goes into the while again and goes back to the previous menu.
        keepLooping = true;
    }

    /**
     * Receives the chosen Genie and prints its menu options.
     * @param chosenGenie Genie
     */
    private static void printMenu(Genie chosenGenie) {
        MenuHelper.printTopLimit("genie menu");
        System.out.println("1 - Make a wish");
        System.out.println("2 - Available wishes");
        System.out.println("3 - Granted wishes");
        if (chosenGenie instanceof Demon) {
            System.out.println("4 - Recharge MagicLamp with Demon");
        }
        System.out.println("0 - Back to Lamp Menu");
        MenuHelper.printBottomLimit();
    }

    private static void handleMenuChoice(Genie chosenGenie, MagicLamp lamp) throws InterruptedException {
        int option = MenuHelper.requestOption();
        switch (option) {
            case 1 -> chosenGenie.grantWish();
            case 2 -> MenuHelper.printOptionResponse("Available wish(es): " + chosenGenie.getAvailableWishes());
            case 3 -> MenuHelper.printOptionResponse("Granted wish(es): " + chosenGenie.getGrantedWishes());
            case 4 -> {
                if (chosenGenie instanceof Demon demon) {
                    lamp.recharge(demon);
                    MenuHelper.printOptionResponse("You have recharged this MagicLamp. Mother Nature thanks you!");
                }
            }
            case 0 -> keepLooping = false;
            default -> ExceptionHelper.handleInputException();
        }
    }

}
