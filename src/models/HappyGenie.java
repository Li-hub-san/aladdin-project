package models;

public class HappyGenie extends Genie {
  public HappyGenie(int wishLimit) {
    super(wishLimit);
  }

  @Override
  protected String getType() {
    return "Happy Genie";
  }

  @Override
  public String toString() {
    return "Happy" + super.toString();
  }
}
