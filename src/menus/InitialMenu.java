package menus;

import helpers.ExceptionHelper;
import helpers.MenuHelper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import models.MagicLamp;

/**
 * Class that handles the initial menu.
 */
public class InitialMenu extends Menu {

    /**
     * List of created lamps.
     */
    private final List<MagicLamp> lamps = new ArrayList<>();

    @Override
    public void show() {
        System.out.println("\nWelcome to Aladdin factory!");

        super.show();

        System.out.println("Ohh no! Hope to see you again!");
    }

    @Override
    protected void printMenu() {
        MenuHelper.printTopLimit("initial menu");
        System.out.println("1 - Create Magic Lamp");
        if (hasMagicLamps()) {
            System.out.println("2 - Select Magic Lamp");
            System.out.println("3 - List Magic Lamps");
        }
        System.out.println("0 - Exit");
        MenuHelper.printBottomLimit();
    }

    /**
     * Requests a menu option choice and handles it. Handles invalid choices by calling {@link
     * ExceptionHelper#handleInputException()}.
     */
    @Override
    protected void handleMenuOption(int option) {
        switch (option) {
            case 1 -> createLamp();
            case 2 -> {
                if (hasMagicLamps()) {
                    new SelectLampMenu(this.lamps).show();
                } else {
                    ExceptionHelper.handleInputException();
                }
            }
            case 3 -> {
                if (hasMagicLamps()) {
                    printLamps();
                } else {
                    ExceptionHelper.handleInputException();
                }
            }
            case 0 -> exitMenu();
            default -> ExceptionHelper.handleInputException();
        }
    }

    /**
     * Indicates whether there are any created lamps.
     */
    private boolean hasMagicLamps() {
        return this.lamps.size() > 0;
    }

    /**
     * Creates a new lamp with a randomly generated genie limit between 1 and 5.
     */
    private void createLamp() {
        MagicLamp magicLamp = new MagicLamp(generateRandomNumberBetween1And5());
        this.lamps.add(magicLamp);
    }

    /**
     * Prints all created lamps.
     */
    private void printLamps() {
        MenuHelper.printTopLimit("magic lamp list", "'");
        this.lamps.forEach(System.out::println);
        MenuHelper.printBottomLimit("'");
    }

    /**
     * Generates a random number between 1 and 5, both inclusive.
     *
     * @return random integer from 1 to 5, both inclusive.
     */
    private int generateRandomNumberBetween1And5() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }

}
