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

    public static void printTopLimit(String menuName) {
        printTopLimit(menuName, "~");
    }

    public static void printTopLimit(String menuName, String character) {
        String separator = repeatChar(character, 19 - menuName.length() / 2);
        String header = "\n" + separator + " " + menuName.toUpperCase() + " " + separator;
        MenuHelper.lastMenuNameLength = header.length() - 1;
        System.out.println(header);
    }

    public static void printBottomLimit() {
        printBottomLimit("~");
    }

    public static void printBottomLimit(String character) {
        System.out.println(repeatChar(character, MenuHelper.lastMenuNameLength));
    }

    private static String repeatChar(String character, int repetitions) {
        String result = "";
        for (int i = 0; i < repetitions; i++) {
            result += character;
        }
        return result;
    }

}
