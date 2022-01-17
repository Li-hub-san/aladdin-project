package models;

public class GrumpyGenie extends Genie {
  public GrumpyGenie(int wishLimit) {
    super(1);
  }

  @Override
  protected String getType() {
    return "Grumpy Genie";
  }

  public boolean wishHasBeenGranted() {
    return false;
  }

  @Override
  public String toString() {
    return "Grumpy" + super.toString();
  }
}
