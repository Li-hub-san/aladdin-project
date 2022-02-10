package helpers;

import java.util.Scanner;

public class MenuHelper {

    private static int lastMenuNameLength;

    public static int requestOption() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Option: ");
        int option = sc.nextInt();
        System.out.println();
        return option;
    }

    public static void printOptionResponse(String output) {
        System.out.println("** " + output + " **");
    }

    public static void printMenuTopLimit(String menuName) {
        String separator = repeatChar("~", 12);
        String header = "\n" + separator + " " + menuName.toUpperCase() + " " + separator;
        MenuHelper.lastMenuNameLength = header.length() - 1;
        System.out.println(header);
    }

    public static void printMenuBottomLimit() {
        System.out.println(repeatChar("~", MenuHelper.lastMenuNameLength));
    }

    private static String repeatChar(String character, int repetitions) {
        String result = "";
        for (int i = 0; i < repetitions; i++) {
            result += character;
        }
        return result;
    }

    public static void printListTopLimit(String menuName) {
        String separator = repeatChar("'", 12);
        String header = "\n" + separator + " " + menuName.toUpperCase() + " " + separator;
        MenuHelper.lastMenuNameLength = header.length() - 1;
        System.out.println(header);
    }

    public static void printListBottomLimit(){
        System.out.println(repeatChar("'", MenuHelper.lastMenuNameLength));
    }

}
