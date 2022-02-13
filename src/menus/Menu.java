package menus;

import helpers.ExceptionHelper;
import java.util.InputMismatchException;

/**
 * Abstract class that defines the general functionality for a menu.
 */
public abstract class Menu {

    /**
     * Indicates whether the menu should keep looping.
     */
    private boolean keepLooping = true;

    /**
     * Prints menu and handles menu choice in a loop until {@link #exitMenu()} is called.
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
     * Breaks the menu's {@link #show()} loop.
     *
     * @see Menu#show()
     */
    protected void exitMenu() {
        keepLooping = false;
    }

    /**
     * Prints the menu's options.
     */
    protected abstract void printMenu();

    /**
     * Requests a menu option choice and handles it.
     *
     * @throws InterruptedException possible throw from Thread.sleep()
     */
    protected abstract void handleMenuChoice() throws InterruptedException;

}
