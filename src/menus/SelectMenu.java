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
     * If the list has only one result, automatically select it.
     * <br>Otherwise, {@link Menu#show()} is called.
     *
     * @throws InterruptedException possible throw from Thread.sleep()
     */
    @Override
    public void show() throws InterruptedException {
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
     * Requests an object choice and opens the next menu. Handles invalid choices by calling {@link
     * ExceptionHelper#handleInputException()}.
     *
     * @throws InterruptedException possible throw from Thread.sleep()
     */
    @Override
    protected void handleMenuChoice() throws InterruptedException {
        try {
            int option = MenuHelper.requestOption();

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
     * @throws InterruptedException possible throw from Thread.sleep().
     */
    protected abstract void openNextMenu(T object) throws InterruptedException;

}
