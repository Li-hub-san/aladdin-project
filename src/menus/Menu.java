package menus;

import helpers.ExceptionHelper;

import java.util.InputMismatchException;

public abstract class Menu {

    protected boolean keepLooping = true;

    /**
     * Loops the printMenu and handleMenuChoice until keepLooping = false.
     *
     * @throws InterruptedException possible throw from Thread.sleep()
     */
    public void show() throws InterruptedException {
        while (keepLooping) {
            printMenu();

            try {
                handleMenuChoice();
            } catch (InputMismatchException exception) {
                ExceptionHelper.handleInputException();
            }
        }
    }

    /**
     * Prints menu options.
     */
    protected abstract void printMenu();

    /**
     * Requests a menu option and handles it.
     *
     * @throws InterruptedException possible throw from Thread.sleep()
     */
    protected abstract void handleMenuChoice() throws InterruptedException;

}
