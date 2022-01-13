public class HappyGenie extends Genie {
  public HappyGenie(int wishLimit) {
    super(wishLimit);
  }

  @Override
  public String toString() {
    return "Happy" + super.toString();
  }
}
