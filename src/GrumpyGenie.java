public class GrumpyGenie extends Genie {
  public GrumpyGenie(int wishLimit) {
    super(1);
  }

  public boolean wishHasBeenGranted() {
    return false;
  }

  @Override
  public String toString() {
    return "Grumpy" + super.toString();
  }
}
