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
     * Receives the chosen MagicLamp, prints the menu and handles the menu choice.
     * @param lamp MagicLamp chosen
     * @throws InterruptedException possible throw from Thread.sleep()
     */
    public static void show(MagicLamp lamp) throws InterruptedException {
        while (keepLooping) {
            printMenu(lamp);

            try {
                handleMenuChoice(lamp);
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
        MenuHelper.printTopLimit("genie List", "'");
        genies.forEach(System.out::println);
        MenuHelper.printBottomLimit("'");
    }

    /**
     * Receives a Lamp and displays its option menu.
     * @param lamp Magic Lamp
     */
    private static void printMenu(MagicLamp lamp) {
        MenuHelper.printTopLimit("lamp menu");
        System.out.println("1 - Rub Lamp");
        System.out.println("2 - Available Genies");
        System.out.println("3 - Released Genies");
        System.out.println("4 - Recharge history");
        if (lamp.hasGenies()) {
            System.out.println("5 - Select Genie");
            System.out.println("6 - List Genies");
        }
        System.out.println("0 - Previous menu");
        MenuHelper.printBottomLimit();
    }

    private static void handleMenuChoice(MagicLamp lamp) throws InterruptedException {
        int choice = MenuHelper.requestOption();

        switch (choice) {
            case 1 -> {
                System.out.println("How many wishes do you want this genie to grant? ");
                Scanner scanner = new Scanner(System.in);
                int wishLimit = scanner.nextInt();
                lamp.rub(wishLimit);
            }
            case 2 -> MenuHelper.printOptionResponse("The MagicLamp " + lamp.getId() + " has " + lamp.getAvailableGenies() + " available genie(s).");
            case 3 -> MenuHelper.printOptionResponse("The MagicLamp " + lamp.getId() + " has released " + lamp.getGenieCounter() + " genie(s).");
            case 4 -> MenuHelper.printOptionResponse("This MagicLamp " + lamp.getId() + " has been recharged " + lamp.getRechargeCounter() + " time(s).");
            case 5 -> {
                if (lamp.hasGenies()) {
                    SelectGenieMenu.show(lamp);
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
