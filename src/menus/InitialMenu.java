package menus;

import models.MagicLamp;
import helpers.ExceptionHelper;
import helpers.MenuHelper;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

public class InitialMenu {

    private static List<MagicLamp> lamps = new ArrayList<>();
    private static boolean keepLooping = true;

    public static void show() throws InterruptedException {
        System.out.println("\nWelcome to Aladdin factory!");

        while (keepLooping) {
            printMenu();

            try {
                handleMenuChoice();
            } catch (InputMismatchException exception) {
                ExceptionHelper.handleInputException();
            }
        }

        System.out.println("Ohh no! Hope to see you again.");
    }

    public static void printMenu() {
        MenuHelper.printMenuNameAndBorder("initial menu");
        System.out.println("1 - Create Magic Lamp");
        if (hasMagicLamps()) {
            System.out.println("2 - List Magic Lamps");
            System.out.println("3 - Select Magic Lamp");
        }
        System.out.println("0 - Exit");
        MenuHelper.printBottomMenuBorder();
    }

    public static void handleMenuChoice() throws InterruptedException {
        int option = MenuHelper.requestOption();
        switch (option) {
            case 1 -> createLamp();
            case 2 -> {
                if (hasMagicLamps()) {
                    listLamps();
                } else {
                    ExceptionHelper.handleInputException();
                }
            }
            case 3 -> SelectLampMenu.show(InitialMenu.lamps);
            case 0 -> keepLooping = false;
            default -> ExceptionHelper.handleInputException();
        }
    }

    private static boolean hasMagicLamps() {
        return InitialMenu.lamps.size() > 0;
    }

    public static void createLamp() {
        MagicLamp magicLamp = new MagicLamp(generateRandomGenie());
        InitialMenu.lamps.add(magicLamp);
    }

    private static void listLamps() {
        System.out.println("----- MagicLamp List -----");
        InitialMenu.lamps.forEach(System.out::println);
        System.out.println("--------------------------");
    }

    public static int generateRandomGenie() {
        Random random = new Random();
        return random.nextInt(5) + 1;
    }

}