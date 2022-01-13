public class Application {

  public static void main(String[] args) {

    MagicLamp firstMagicLamp = new MagicLamp(2);

    Genie firstGenie = firstMagicLamp.rub(3);
    System.out.println(firstGenie);

    Genie secondGenie = firstMagicLamp.rub(3);
    System.out.println(secondGenie);

    Genie thirdGenie = firstMagicLamp.rub(3);
    System.out.println(thirdGenie);


    if (thirdGenie instanceof Demon) {
      firstMagicLamp.recharge((Demon) thirdGenie);
    }

    firstGenie.grantWish();
    firstGenie.grantWish();

    thirdGenie.grantWish();
    System.out.println(firstMagicLamp);

  }

}
