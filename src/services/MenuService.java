package services;

import models.Genie;
import models.MagicLamp;

import java.util.*;

public class MenuService {

    private Random ran = new Random();
    private List<MagicLamp> lamps = new ArrayList<>();
    private List<Genie> genies = new ArrayList<>();
    private boolean wasListed;

//    public void showInitialMenu() throws InterruptedException {
//        System.out.println("\nWelcome to Aladdin factory!");
//
////    noinspection InfiniteLoopStatement
//        while (true) {
//            System.out.println("\n------ INITIAL MENU ------");
//            System.out.println("1 - Create Magic Lamp");
//            if (hasMagicLamps()) {
//                System.out.println("2 - List Magic Lamps");
//                // Só é possivel seleccionar a lampada depois de listar.
//                System.out.println("3 - Select Magic Lamp");
//            }
//            System.out.println("0 - Exit");
//            System.out.println("--------------------------");
//
//            try {
//                Scanner sc = new Scanner(System.in);
//                int choice = sc.nextInt();
//                switch (choice) {
//                    case 1 -> createLamp();
//                    case 2 -> {
//                        if (hasMagicLamps()) {
//                            listLamps();
//
//                        } else {
//                            handleInputException();
//                        }
//                    }
//          case 3 -> showLampMenu();
//                    case 0 -> exitApplication();
//          default -> handleInputException();
//                }
//
//            } catch (InputMismatchException exception) {
//                handleInputException();
//            }
//        }
//    }

    public void showLampMenu(MagicLamp lamp) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int wishLimit = scanner.nextInt();

        while (true) {
            System.out.println("\n------- LAMP MENU -------");
            System.out.println("1 - Rub Lamp");
            System.out.println("2 - Available Genies");
            System.out.println("3 - Released Genies");
            System.out.println("4 - List Genies");
            System.out.println("5 - Recharge history");
            System.out.println("6 - Previous menu");
            System.out.println("--------------------------");

            try {
                Scanner sc = new Scanner(System.in);
                int choice = sc.nextInt();
                switch (choice) {
                    case 1 -> lamp.rub(wishLimit);
                    case 2 -> lamp.getAvailableGenies();
                    case 3 -> System.out.println("The MagicLamp has released " + lamp.getGenieCounter() + " genie(s).");
                    case 4 -> {
                        if (hasGenies()) {
                            listGenies();
                        } else {
                            handleInputException();
                        }
                    }
                    case 5 -> System.out.println("This MagicLamp has been recharged " + lamp.getRechargeCounter() + " time(s).");
//                case 6 -> showInitialMenu();
                    default -> handleInputException();
                }
            } catch (InputMismatchException exception) {
                handleInputException();
            }
        }

    }


    public void selectLamp(int lampNumber) {
        System.out.println(lamps.get(lampNumber - 1));
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

    private boolean hasGenies() {
        return this.genies.size() > 0;
    }

    private void listGenies() {
        this.genies.forEach(System.out::println);
    }

}
