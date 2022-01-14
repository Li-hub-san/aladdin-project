import java.util.Scanner;

public class Application {

  public static void main(String[] args) {

    Scanner sc =new Scanner(System.in);
    initialMenu();
    MagicLamp firstMagicLamp = new MagicLamp(2);

    Genie firstGenie = firstMagicLamp.rub(3);
//    System.out.println(firstGenie);

    if (firstGenie instanceof Demon) {
      firstMagicLamp.recharge((Demon) firstGenie);
    }
  }

  public static void initialMenu(){
    System.out.println("Welcome to Aladdin factory!" + "\n" + "Create Magic Lamp(1) | Exit(2)");
  }

}
