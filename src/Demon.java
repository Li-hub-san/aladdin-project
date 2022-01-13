public class Demon extends Genie {
  private boolean fedToMagicLamp = false;

  public Demon(int wishLimit) {
    super(Integer.MAX_VALUE);
  }

  public void setFedToMagicLamp(boolean fedToMagicLamp) {
    this.fedToMagicLamp = fedToMagicLamp;
  }

  @Override
  public void grantWish() {
    if (!fedToMagicLamp) {
      super.grantWish();
    } else {
      System.out.println("You have used the Demon to recharge the lamp. There are no more wishes left to use.");
    }
  }

  @Override
  public String toString() {
    return "Demon {" +
        "wishLimit=unlimited" +
        ", wishCounter=" + wishCounter +
        ", fedToMagicLamp=" + fedToMagicLamp +
        '}';
  }
}
