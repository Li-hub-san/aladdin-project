package menus;

import helpers.ExceptionHelper;
import helpers.MenuHelper;
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
     * Prints the current menu options and handles its choice in a loop until {@link #exitMenu()} is called.
     */
    public void show() {
        while (keepLooping) {
            printMenu();

            try {
                int option = MenuHelper.requestOption();
                handleMenuOption(option);
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
     * Handles the selected menu option.
     *
     * @param option the selected menu option.
     */
    protected abstract void handleMenuOption(int option);

}
