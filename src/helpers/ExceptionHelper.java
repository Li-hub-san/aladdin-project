package helpers;

public class ExceptionHelper {

    public static void handleInputException() throws InterruptedException {
        System.out.println("Invalid option.");
        Thread.sleep(1000);
    }

}
