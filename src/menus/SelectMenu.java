package menus;

import helpers.ExceptionHelper;
import helpers.MenuHelper;
import java.util.List;

/**
 * Abstract class that defines the general functionality for menus that aim at selecting one object out of a list of
 * objects.
 *
 * @param <T> type of object used within the list.
 */
public abstract class SelectMenu<T> extends Menu {

    /**
     * Checks if the list of objects has only one object, automatically selecting it in case it does.
     * <br>Otherwise, {@link Menu#show()} is called.
     */
    @Override
    public void show() {
        if (getList().size() == 1) {
            openNextMenu(getList().get(0));
            return;
        }
        super.show();
    }

    /**
     * Prints the list of objects as menu options.
     */
    @Override
    protected void printMenu() {
        MenuHelper.printTopLimit(getMenuName());
        for (int i = 0; i < getList().size(); i++) {
            T currentObject = getList().get(i);
            System.out.println((i + 1) + " - " + currentObject);
        }
        System.out.println("0 - Cancel");
        MenuHelper.printBottomLimit();
    }

    /**
     * Takes in the selected menu option and opens the next menu with the corresponding object from the list. Handles
     * invalid choices by calling {@link ExceptionHelper#handleInputException()}.
     *
     * @param option the selected option
     */
    @Override
    protected void handleMenuOption(int option) {
        try {
            if (option > 0 && option <= getList().size()) {
                T object = getList().get(option - 1);
                openNextMenu(object);
                exitMenu();
            } else if (option != 0) {
                ExceptionHelper.handleInputException();
            } else {
                exitMenu();
            }
        } catch (Exception exception) {
            ExceptionHelper.handleInputException();
        }
    }

    /**
     * Returns the current menu's name.
     *
     * @return menu name.
     */
    protected abstract String getMenuName();

    /**
     * Returns the current menu's object list.
     *
     * @return object list.
     */
    protected abstract List<T> getList();

    /**
     * Opens the menu that should be shown after selecting one of the current list objects.
     *
     * @param object the selected object.
     */
    protected abstract void openNextMenu(T object);

}
