import java.util.Random;
import java.util.Scanner;

public class Application {

    static Random ran = new Random();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Welcome to Aladdin factory!" + "\n" + "Create Magic Lamp(1) | Exit(2)");

        int firstChoice = sc.nextInt();

        initialMenu(firstChoice);
    }

    public static void initialMenu(int firstChoice) {
        if (firstChoice == 1) {
            createLamp();
        } else {
            System.out.println("Ohh no! Hope to see you again.");
            System.exit(0);
        }

    }

    public static int generateRandomGenie() {
        return ran.nextInt(10) + 1;
    }

    public static void createLamp() {
        MagicLamp firstMagicLamp = new MagicLamp(generateRandomGenie());

        System.out.println("How many wishes fo you want to grant?");
        int numberOfWishes = sc.nextInt();
        Genie firstGenie = firstMagicLamp.rub(numberOfWishes);
        firstGenie.grantWish();

        if (firstGenie instanceof Demon) {
            firstMagicLamp.recharge((Demon) firstGenie);
        }
    }

}
