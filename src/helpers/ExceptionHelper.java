package helpers;

/**
 * Helper class to handle exceptions thrown by the application.
 */
public class ExceptionHelper {

    /**
     * Prints a message to the console letting the user know that the input used is invalid. Halts the application
     * execution for 1.5 seconds before continuing.
     *
     * @throws InterruptedException possible throw from Thread.sleep().
     */
    public static void handleInputException() throws InterruptedException {
        System.out.println("Invalid option.");
        Thread.sleep(1500);
    }

}
