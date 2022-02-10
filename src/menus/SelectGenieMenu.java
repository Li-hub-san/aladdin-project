package menus;

import models.Genie;
import models.MagicLamp;
import helpers.ExceptionHelper;
import helpers.MenuHelper;

public class SelectGenieMenu {

    public static void show(MagicLamp lamp) throws InterruptedException {
        if (lamp.getGenies().size() == 1) {
            GenieMenu.show(lamp.getGenies().get(0), lamp);
            return;
        }

        MenuHelper.printTopLimit("select genie menu");
        for (int i = 0; i < lamp.getGenies().size(); i++) {
            Genie currentGenie = lamp.getGenies().get(i);
            System.out.println((i + 1) + " - " + currentGenie);
        }
        System.out.println("0 - Cancel");
        MenuHelper.printBottomLimit();

        try {
            int option = MenuHelper.requestOption();

            if (option > 0 && option <= lamp.getGenies().size()) {
                Genie chosenGenie = lamp.getGenies().get(option - 1);
                GenieMenu.show(chosenGenie, lamp);
            } else if (option != 0) {
                handleException(lamp);
            }
        } catch (Exception exception) {
            handleException(lamp);
        }
    }

    /**
     * Receives a MagicLamp, handles the input Exception and re-shows the menu.
     * @param lamp MagicLamp
     * @throws InterruptedException possible throw from Thread.sleep()
     */
    private static void handleException(MagicLamp lamp) throws InterruptedException {
        ExceptionHelper.handleInputException();
        show(lamp);
    }

}
