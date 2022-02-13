package helpers;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Helper class with methods that are useful to print/handle menus.
 */
public class MenuHelper {

    /**
     * Keeps the length of the last printed menu's name.
     */
    private static int lastMenuNameLength;

    /**
     * Requests a user input for menu option selection.
     *
     * @return the selected option number.
     */
    public static int requestOption() {
        System.out.print("Option: ");

        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        System.out.println();

        return option;
    }

    /**
     * Prints a system message as response to a previously selected option.
     *
     * @param output message to display.
     */
    public static void printOptionResponse(String output) {
        System.out.println("** " + output + " **");
    }

    /**
     * Prints a menu's top limit: composed of a new line, followed by the menu's name centered using '~' characters as
     * padding.
     *
     * @param menuName name of the menu being printed.
     */
    public static void printTopLimit(String menuName) {
        printTopLimit(menuName, "~");
    }

    /**
     * Prints a menu's top limit: composed of a new line, followed by the menu's name centered using a given character
     * as padding.
     *
     * @param menuName name of the menu being printed.
     * @param character character used to space menu name.
     */
    public static void printTopLimit(String menuName, String character) {
        printTopLimit(menuName, character, "\n");
    }

    /**
     * Prints a menu's top limit: composed of a given prefix, followed by the menu's name centered using a given
     * character as padding.
     *
     * @param menuName name of the menu being printed.
     * @param character character used to space menu name.
     */
    public static void printTopLimit(String menuName, String character, String prefix) {
        String separator = repeatChar(character, 19 - menuName.length() / 2);
        String header = prefix + separator + " " + menuName.toUpperCase() + " " + separator;
        MenuHelper.lastMenuNameLength = header.length() - 1;
        System.out.println(header);
    }

    /**
     * Prints a menu's bottom limit using a '~' character to fill the line.
     */
    public static void printBottomLimit() {
        printBottomLimit("~");
    }

    /**
     * Prints a menu's bottom limit using a given character to fill the line.
     *
     * @param character character used to fill line.
     */
    public static void printBottomLimit(String character) {
        System.out.println(repeatChar(character, MenuHelper.lastMenuNameLength));
    }

    /**
     * Returns a given character repeated a given number of times.
     *
     * @param character character to repeat.
     * @param repetitions number of times to repeat.
     * @return character repeated as many times as {@code repetitions}.
     */
    private static String repeatChar(String character, int repetitions) {
        String result = "";
        for (int i = 0; i < repetitions; i++) {
            result += character;
        }
        return result;
    }

    /**
     * Formats a given double into it's integer representation and returns it as a String.
     *
     * @param number number to format.
     * @return {@code number} as a string without decimal cases.
     */
    public static String toSingleCase(double number) {
        DecimalFormat decimalFormat = new DecimalFormat("#");
        return decimalFormat.format(number);
    }

}
