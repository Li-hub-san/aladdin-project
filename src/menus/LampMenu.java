package menus;

import models.Genie;
import models.MagicLamp;
import helpers.ExceptionHelper;
import helpers.MenuHelper;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LampMenu {

    public static void show(MagicLamp lamp, List<MagicLamp> lamps) throws InterruptedException {
        boolean keepLooping = true;
        while (keepLooping) {
            try {
                MenuHelper.printMenuNameAndBorder("lamp menu");
                System.out.println("1 - Rub Lamp");
                System.out.println("2 - Available Genies");
                System.out.println("3 - Released Genies");
                System.out.println("4 - Recharge history");
                if (lamp.hasGenies()) {
                    System.out.println("5 - List Genies");
                    System.out.println("6 - Select Genie");
                }
                System.out.println("0 - Previous menu");
                MenuHelper.printBottomMenuBorder();

                int choice = MenuHelper.requestOption();
                switch (choice) {
                    case 1 -> {
                        System.out.println("How many wishes do you want this genie to grant? ");
                        Scanner scanner = new Scanner(System.in);
                        int wishLimit = scanner.nextInt();
                        lamp.rub(wishLimit);
                    }
                    case 2 -> System.out.println("The MagicLamp has " + lamp.getAvailableGenies() + " available genie(s).");
                    case 3 -> System.out.println("The MagicLamp has released " + lamp.getGenieCounter() + " genie(s).");
                    case 4 -> System.out.println("This MagicLamp has been recharged " + lamp.getRechargeCounter() + " time(s).");
                    case 5 -> {
                        if (lamp.hasGenies()) {
                            listGenies(lamp.getGenies());
                        } else {
                            ExceptionHelper.handleInputException();
                        }
                    }
                    case 6 -> {
                        if (lamp.hasGenies()) {
                            SelectGenieMenu.show(lamp, lamps);
                        } else {
                            ExceptionHelper.handleInputException();
                        }
                    }
                    case 0 -> keepLooping = false;
                    default -> ExceptionHelper.handleInputException();
                }
            } catch (InputMismatchException exception) {
                ExceptionHelper.handleInputException();
            }
        }
    }

    private static void listGenies(List<Genie> genies) {
        System.out.println("_______ Genie List _______");
        genies.forEach(System.out::println);
    }

}
