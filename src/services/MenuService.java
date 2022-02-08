package services;

import models.Genie;
import models.MagicLamp;

import java.util.*;

public class MenuService {

    private Random ran = new Random();
    private List<MagicLamp> lamps = new ArrayList<>();


    public void showInitialMenu() throws InterruptedException {
        System.out.println("\nWelcome to Aladdin factory!");

//    noinspection InfiniteLoopStatement
        while (true) {
            System.out.println("\n------ INITIAL MENU ------");
            System.out.println("1 - Create Magic Lamp");
            if (hasMagicLamps()) {
                System.out.println("2 - List Magic Lamps");
                // Só é possivel seleccionar a lampada depois de listar.
                System.out.println("3 - Select Magic Lamp");
            }
            System.out.println("0 - Exit");
            System.out.println("--------------------------");

            try {
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> createLamp();
                    case 2 -> {
                        if (hasMagicLamps()) {
                            listLamps();
                        } else {
                            handleInputException();
                        }
                    }
                    case 3 -> selectLamp();
                    case 0 -> exitApplication();
                    default -> handleInputException();
                }

            } catch (InputMismatchException exception) {
                handleInputException();
            }
        }
    }

    public void selectLamp() throws InterruptedException {
        System.out.println("\n--- SELECT LAMP MENU ---");
        for (int i = 0; i < lamps.size(); i++) {
            MagicLamp currentLamp = lamps.get(i);
            System.out.println((i + 1) + " - " + currentLamp);
        }
        System.out.println("0 - Cancel");
        System.out.println("--------------------------");
        try {
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            if (choice > 0 && choice <= lamps.size()) {
                MagicLamp userChoice = lamps.get(choice - 1);
                showLampMenu(userChoice);
            } else if (choice != 0) {
                handleInputException();
                selectLamp();
            }
        } catch (Exception exception) {
            handleInputException();
            selectLamp();
        }
    }

    public void selectGenie(MagicLamp lamp) throws InterruptedException {
        System.out.println("\n--- SELECT GENIE MENU ---");
        for (int i = 0; i < lamp.getGenies().size(); i++) {
            Genie currentGenie = lamp.getGenies().get(i);
            System.out.println((i + 1) + " - " + currentGenie);
        }
        System.out.println("0 - Cancel");
        System.out.println("---------------------------");
        try {
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();

            if (choice > 0 && choice <= lamp.getGenies().size()) {
                Genie userChoice = lamp.getGenies().get(choice - 1);
                showGenieMenu(userChoice);
            } else if (choice != 0) {
                handleInputException();
                selectGenie(lamp);
            }
        } catch (Exception exception) {
            handleInputException();
            selectLamp();
        }
    }

    private void showGenieMenu(Genie userChoice) throws InterruptedException {

        while (true) {
            try {
                System.out.println("\n------- GENIE MENU -------");
                System.out.println("1 - Grant wishes");
                System.out.println("1 - Available wishes");
                System.out.println("2 - Granted wishes");
                System.out.println("0 - Cancel");
                System.out.println("--------------------------");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> {
                        Scanner scanner = new Scanner(System.in);
                        int wishLimit = scanner.nextInt();
                        userChoice.grantWish();
                    }
                    case 2 -> System.out.println("This Genie has " + userChoice.getAvailableWishes() + " available wish(es).");
                    case 3 -> System.out.println("The MagicLamp has released " + userChoice.getGrantedWishes() + " granted wish(es).");
                    default -> handleInputException();
                }
            } catch (InputMismatchException exception) {
                handleInputException();
            }
        }

    }

    public void showLampMenu(MagicLamp lamp) throws InterruptedException {
        while (true) {
            try {
                System.out.println("\n------- LAMP MENU -------");
                System.out.println("1 - Rub Lamp");
                System.out.println("2 - Available Genies");
                System.out.println("3 - Released Genies");
                System.out.println("4 - Recharge history");
                if (lamp.hasGenies()) {
                    System.out.println("5 - List Genies");
                }
                System.out.println("0 - Previous menu");
                System.out.println("--------------------------");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
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
                            handleInputException();
                        }
                    }
                    case 0 -> showInitialMenu();
                    default -> handleInputException();
                }
            } catch (InputMismatchException exception) {
                handleInputException();
            }
        }

    }

    private void listGenies(List<Genie> genies) {
        genies.forEach(System.out::println);
    }


    private boolean hasMagicLamps() {
        return this.lamps.size() > 0;
    }

    private void listLamps() {
        this.lamps.forEach(System.out::println);
    }


    public void exitApplication() {
        System.out.println("Ohh no! Hope to see you again.");
        System.exit(0);
    }

    public void handleInputException() throws InterruptedException {
        System.out.println("Invalid option.");
        Thread.sleep(1000);
    }

    public int generateRandomGenie() {
        return ran.nextInt(10) + 1;
    }

    public void createLamp() {
        MagicLamp magicLamp = new MagicLamp(generateRandomGenie());
        this.lamps.add(magicLamp);

    }

}
