package menus;

import models.MagicLamp;
import helpers.ExceptionHelper;
import helpers.MenuHelper;

import java.util.List;

public class SelectLampMenu {

    public static void show(List<MagicLamp> lamps) throws InterruptedException {
        if (lamps.size() == 1) {
            LampMenu.show(lamps.get(0));
            return;
        }

        MenuHelper.printTopLimit("select lamp menu");
        for (int i = 0; i < lamps.size(); i++) {
            MagicLamp currentLamp = lamps.get(i);
            System.out.println((i + 1) + " - " + currentLamp);
        }
        System.out.println("0 - Cancel");
        MenuHelper.printBottomLimit();

        try {
            int option = MenuHelper.requestOption();

            if (option > 0 && option <= lamps.size()) {
                MagicLamp chosenLamp = lamps.get(option - 1);
                LampMenu.show(chosenLamp);
            } else if (option != 0) {
                ExceptionHelper.handleInputException();
                show(lamps);
            }
        } catch (Exception exception) {
            ExceptionHelper.handleInputException();
            show(lamps);
        }
    }

}

