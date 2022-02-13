package helpers;

/**
 * Helper class to handle exceptions thrown by the application.
 */
public class ExceptionHelper {

    /**
     * Prints a message to the console letting the user know that the input used is invalid. Halts the application
     * execution for 1.5 seconds before continuing. Prints a warning message if {@code Thread.sleep()} triggers an
     * {@link InterruptedException}.
     */
    public static void handleInputException() {
        MenuHelper.printOptionResponse("Invalid option.");

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("An exception was thrown when pausing application using Thread.sleep().");
        }
    }

}
