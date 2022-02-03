package models;

public class MagicLamp {
  private final int genieLimit;
  private int genieCounter;
  private int rubCounter;
  private int rechargeCounter;

  public MagicLamp(int genieLimit) {
    this.genieLimit = genieLimit;
    System.out.println("You created a Magic Lamp!");
  }

  public int getRechargeCounter() {
    return rechargeCounter;
  }

  public int getAvailableGenies() {
    return genieLimit - genieCounter;
  }

  public int getGenieCounter() {
    return genieCounter;
  }

  public void setGenieCounter(int genieCounter) {
    this.genieCounter = genieCounter;
  }

  public Genie rub(int expectedWishCount) {

    if (getAvailableGenies() < 1) {
      rubCounter++;
      genieCounter++;
      return new Demon(expectedWishCount);
    }

    if (rubCounter % 2 == 0) {
      rubCounter++;
      genieCounter++;
      return new GrumpyGenie(expectedWishCount);
    }

    rubCounter++;
    genieCounter++;
    return new HappyGenie(expectedWishCount);
  }

  public void recharge(Demon demon) {
    rechargeCounter++;
    genieCounter = 0;
    demon.setFedToMagicLamp(true);
  }

  @Override
  public String toString() {
    return "This MagicLamp contains a " + genieLimit + " genie limit with " + rechargeCounter +
        " recharges, " + genieCounter + " released genies, and " + rubCounter + " rubs.";
  }
}
