package menus;

import models.Genie;
import models.MagicLamp;
import helpers.ExceptionHelper;
import helpers.MenuHelper;

import java.util.List;

public class SelectGenieMenu {

    public static void show(MagicLamp lamp, List<MagicLamp> lamps) throws InterruptedException {
        if (lamp.getGenies().size() == 1) {
            GenieMenu.show(lamp.getGenies().get(0), lamp);
            return;
        }

        System.out.println("\n--- SELECT GENIE MENU ---");
        for (int i = 0; i < lamp.getGenies().size(); i++) {
            Genie currentGenie = lamp.getGenies().get(i);
            System.out.println((i + 1) + " - " + currentGenie);
        }
        System.out.println("0 - Cancel");
        System.out.println("---------------------------");
        System.out.print("Option: ");

        try {
            int option = MenuHelper.requestOption();
            if (option > 0 && option <= lamp.getGenies().size()) {
                Genie chosenGenie = lamp.getGenies().get(option - 1);
                GenieMenu.show(chosenGenie, lamp);
            } else if (option != 0) {
                ExceptionHelper.handleInputException();
                show(lamp, lamps);
            }
        } catch (Exception exception) {
            ExceptionHelper.handleInputException();
            SelectLampMenu.show(lamps);
        }
    }

}
