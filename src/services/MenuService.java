package services;

import models.Demon;
import models.Genie;
import models.MagicLamp;

import java.util.*;

public class MenuService {

    private Random random = new Random();
    private List<MagicLamp> lamps = new ArrayList<>();


    public void showInitialMenu() throws InterruptedException {
        System.out.println("\nWelcome to Aladdin factory!");

//    noinspection InfiniteLoopStatement
        while (true) {
            System.out.println("\n------ INITIAL MENU ------");
            System.out.println("1 - Create Magic Lamp");
            if (hasMagicLamps()) {
                System.out.println("2 - List Magic Lamps");
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
        if (lamps.size() == 1) {
            showLampMenu(lamps.get(0));
            return;
        }

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
                MagicLamp chosenLamp = lamps.get(choice - 1);
                showLampMenu(chosenLamp);
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
        if (lamp.getGenies().size() == 1) {
            showGenieMenu(lamp.getGenies().get(0));
            return;
        }

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
                Genie chosenGenie = lamp.getGenies().get(choice - 1);
                showGenieMenu(chosenGenie);
            } else if (choice != 0) {
                handleInputException();
                selectGenie(lamp);
            }
        } catch (Exception exception) {
            handleInputException();
            selectLamp();
        }
    }

    private void showGenieMenu(Genie chosenGenie) throws InterruptedException {
        boolean keepLooping = true;
        while (keepLooping) {
            try {
                System.out.println("\n------- GENIE MENU -------");
                System.out.println("1 - Make a wish");
                System.out.println("2 - Available wishes");
                System.out.println("3 - Granted wishes");
                if (chosenGenie instanceof Demon) {
                    System.out.println("4 - Recharge MagicLamp with Demon");
                }
                System.out.println("0 - Back to Lamp Menu");
                System.out.println("--------------------------");
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> chosenGenie.grantWish();
                    case 2 -> System.out.println("This Genie has " + chosenGenie.getAvailableWishes() + " available wish(es).");
                    case 3 -> System.out.println("This Genie has granted " + chosenGenie.getGrantedWishes() + " wish(es).");
                    case 4 -> {
                        if (chosenGenie instanceof Demon) {
                            ((Demon) chosenGenie).setFedToMagicLamp(true);
                            System.out.println("You have recharged this MagicLamp. Mother Nature thanks you!");
                            //Still have to understand how to lamp.recharge(demon);

                        }
                    }
                    case 0 -> keepLooping = false;
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
                    System.out.println("6 - Select Genie");
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
                    case 6 -> {
                        if (lamp.hasGenies()) {
                            selectGenie(lamp);
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
        System.out.println("------- Genie List -------");
        genies.forEach(System.out::println);
        System.out.println("--------------------------");
    }


    private boolean hasMagicLamps() {
        return this.lamps.size() > 0;
    }

    private void listLamps() {
        System.out.println("----- MagicLamp List -----");
        this.lamps.forEach(System.out::println);
        System.out.println("--------------------------");
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
        return random.nextInt(10) + 1;
    }

    public void createLamp() {
        MagicLamp magicLamp = new MagicLamp(generateRandomGenie());
        this.lamps.add(magicLamp);
    }

}
