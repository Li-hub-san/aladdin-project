package models;

import java.util.Scanner;

public abstract class Genie {
  protected int wishLimit;
  protected int wishCounter;

  public Genie(int wishLimit) {
    this.wishLimit = wishLimit;
    System.out.println("A " + this.getType() + " appears before you!");
  }

  protected abstract String getType();

  public int getGrantedWishes() {
    return wishCounter;
  }

  public int getAvailableWishes() {
    return wishLimit - wishCounter;
  }

  public void grantWish() {
    if (this.wishLimit > this.wishCounter) {
      System.out.println("Make a wish: ");

      Scanner sc = new Scanner(System.in);
      String wish = sc.nextLine();
      wishCounter++;
      System.out.println("** Wish '" + wish + "' granted, " + getAvailableWishes() + " wish(es) left **");
    } else {
      System.out.println("No wishes left!");
    }
  }

  @Override
  public String toString() {
    return "Genie{" +
        "wishLimit=" + wishLimit +
        ", wishCounter=" + wishCounter +
        '}';
  }
}
