package menus;

import helpers.ExceptionHelper;
import helpers.MenuHelper;
import models.Genie;
import models.MagicLamp;

import java.util.List;
import java.util.Scanner;

public class LampMenu extends Menu {

    private final MagicLamp lamp;

    public LampMenu(MagicLamp lamp) {
        this.lamp = lamp;
    }

    @Override
    protected void printMenu() {
        MenuHelper.printTopLimit("lamp menu");
        MenuHelper.printTopLimit("magic lamp " + lamp.getId(), ".", "");
        System.out.println("1 - Rub Lamp");
        System.out.println("2 - Available Genies");
        System.out.println("3 - Released Genies");
        System.out.println("4 - Recharge history");
        // system.out.print -> ver historico de desejos -> imprime a lista
        if (lamp.hasGenies()) {
            System.out.println("5 - Select Genie");
            System.out.println("6 - List Genies");
        }
        System.out.println("0 - Previous menu");
        MenuHelper.printBottomLimit();
    }

    @Override
    protected void handleMenuChoice() throws InterruptedException {
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
                    new SelectGenieMenu(lamp).show();
                } else {
                    ExceptionHelper.handleInputException();
                }
            }
            case 6 -> {
                if (lamp.hasGenies()) {
                    printGenies(lamp.getGenies());
                } else {
                    ExceptionHelper.handleInputException();
                }
            }
            case 0 -> keepLooping = false;
            default -> ExceptionHelper.handleInputException();
        }
    }

    /**
     * Receives a list of Genies and prints all elements.
     *
     * @param genies List of Genies
     */
    private void printGenies(List<Genie> genies) {
        MenuHelper.printTopLimit("genie List", "'");
        genies.forEach(System.out::println);
        MenuHelper.printBottomLimit("'");
    }

}
