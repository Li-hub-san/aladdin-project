package menus;

import helpers.ExceptionHelper;
import helpers.MenuHelper;

import java.util.List;

public abstract class SelectMenu<T> extends Menu {

    @Override
    public void show() throws InterruptedException {
        if (getList().size() == 1) {
            openNextMenu(getList().get(0));
            return;
        }
        super.show();
    }

    @Override
    protected void printMenu() {
        MenuHelper.printTopLimit(getMenuName());
        for (int i = 0; i < getList().size(); i++) {
            Object currentObject = getList().get(i);
            System.out.println((i + 1) + " - " + currentObject);
        }
        System.out.println("0 - Cancel");
        MenuHelper.printBottomLimit();
    }

    @Override
    protected void handleMenuChoice() throws InterruptedException {
        try {
            int option = MenuHelper.requestOption();

            if (option > 0 && option <= getList().size()) {
                T object = getList().get(option - 1);
                openNextMenu(object);
                keepLooping = false;
            } else if (option != 0) {
                ExceptionHelper.handleInputException();
            } else {
                keepLooping = false;
            }
        } catch (Exception exception) {
            ExceptionHelper.handleInputException();
        }
    }

    protected abstract String getMenuName();

    protected abstract List<T> getList();

    protected abstract void openNextMenu(T object) throws InterruptedException;

}
