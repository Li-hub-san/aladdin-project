package services;

import models.MagicLamp;

import java.util.*;

public class MenuService {

  private Random ran = new Random();
  private List<MagicLamp> lamps = new ArrayList<>();

  public void showInitialMenu() throws InterruptedException {
    System.out.println("\nWelcome to Aladdin factory!");

    //noinspection InfiniteLoopStatement
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
          case 3 -> {
            if(choice <= lamps.size()){
              selectLamp(choice);
            } else{
              System.out.println("bla");
            }
          }
          case 0 -> exitApplication();
          default -> handleInputException();
        }
      } catch (InputMismatchException exception) {
        handleInputException();
      }
    }
  }

  public void selectLamp(int lampNumber) {
    System.out.println(lamps);
  }

  /**
   * Verifies the list size.
   * @return boolean
   */
  private boolean hasMagicLamps() {
    return this.lamps.size() > 0;
  }

  /**
   * Lists all lamps.
   */
  private void listLamps() {
    this.lamps.forEach(System.out::println);
  }

  /**
   * Exits console.
   */
  public void exitApplication() {
    System.out.println("Ohh no! Hope to see you again.");
    System.exit(0);
  }

  public void handleInputException() throws InterruptedException {
    System.out.println("Invalid option.");
    Thread.sleep(1000);
  }

  /**
   * Generates a random number.
   * @return int random number
   */
  public int generateRandomGenie() {
    return ran.nextInt(10) + 1;
  }

  /**
   * creates a new MagicLamp
   */
  public void createLamp() {
    MagicLamp magicLamp = new MagicLamp(generateRandomGenie());
    this.lamps.add(magicLamp);


//    if (genie instanceof models.Demon) {
//      magicLamp.recharge((models.Demon) genie);
//    }
  }

//  public void generateWishes() {
//    System.out.println("How many wishes do you want to be granted?");
//    Scanner sc = new Scanner(System.in);
//    int numberOfWishes = sc.nextInt();
//    models.Genie genie = magicLamp.rub(numberOfWishes);
////    genie.grantWish();
//  }

}
