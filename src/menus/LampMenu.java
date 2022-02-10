package menus;

import helpers.ExceptionHelper;
import helpers.MenuHelper;
import models.Genie;
import models.MagicLamp;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LampMenu {

    private static boolean keepLooping = true;

    /**
     * Receives the chosen Lamp and list of lamps.
     * @param lamp Magic Lamp chosen
     * @param lamps List of created Magic Lamps
     * @throws InterruptedException Exception - all the numbers that is not an option of the menu
     */
    public static void show(MagicLamp lamp, List<MagicLamp> lamps) throws InterruptedException {
        while (keepLooping) {
            printMenu(lamp);

            try {
                handleMenuChoice(lamp, lamps);
            } catch (InputMismatchException exception) {
                ExceptionHelper.handleInputException();
            }
        }

        // Declared to false in handleMenuChoice();
        // Needs to be reset, or it never goes into the while again and goes back to the previous menu.
        keepLooping = true;
    }

    /**
     * Receives a list of Genies and prints every element.
     * @param genies List of Genies
     */
    private static void listGenies(List<Genie> genies) {
        MenuHelper.printListTopLimit("genie List");
        genies.forEach(System.out::println);
        MenuHelper.printListBottomLimit();
    }

    /**
     * Receives a Lamp and displays its option menu.
     * @param lamp Magic Lamp
     */
    private static void printMenu(MagicLamp lamp) {
        MenuHelper.printMenuTopLimit("lamp menu");
        System.out.println("1 - Rub Lamp");
        System.out.println("2 - Available Genies");
        System.out.println("3 - Released Genies");
        System.out.println("4 - Recharge history");
        if (lamp.hasGenies()) {
            System.out.println("5 - Select Genie");
            System.out.println("6 - List Genies");
        }
        System.out.println("0 - Previous menu");
        MenuHelper.printMenuBottomLimit();
    }

    private static void handleMenuChoice(MagicLamp lamp, List<MagicLamp> lamps) throws InterruptedException {
        int choice = MenuHelper.requestOption();

        switch (choice) {
            case 1 -> {
                System.out.println("How many wishes do you want this genie to grant? ");
                Scanner scanner = new Scanner(System.in);
                int wishLimit = scanner.nextInt();
                lamp.rub(wishLimit);
            }
            case 2 -> MenuHelper.printOptionResponse("The MagicLamp has " + lamp.getAvailableGenies() + " available genie(s).");
            case 3 -> MenuHelper.printOptionResponse("The MagicLamp has released " + lamp.getGenieCounter() + " genie(s).");
            case 4 -> MenuHelper.printOptionResponse("This MagicLamp has been recharged " + lamp.getRechargeCounter() + " time(s).");
            case 5 -> {
                if (lamp.hasGenies()) {
                    SelectGenieMenu.show(lamp, lamps);
                } else {
                    ExceptionHelper.handleInputException();
                }
            }
            case 6 -> {
                if (lamp.hasGenies()) {
                    listGenies(lamp.getGenies());
                } else {
                    ExceptionHelper.handleInputException();
                }
            }
            case 0 -> keepLooping = false;
            default -> ExceptionHelper.handleInputException();
        }
    }

}
