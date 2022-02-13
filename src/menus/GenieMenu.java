package menus;

import helpers.ExceptionHelper;
import helpers.MenuHelper;
import java.util.Scanner;
import models.Demon;
import models.Genie;
import models.MagicLamp;

/**
 * Class that handles the genie menu.
 */
public class GenieMenu extends Menu {

    /**
     * Selected lamp.
     */
    private final MagicLamp lamp;

    /**
     * Selected genie.
     */
    private final Genie genie;

    /**
     * Requires the selected lamp and selected genie to initialize the {@link GenieMenu}.
     *
     * @param lamp selected lamp.
     * @param genie selected genie.
     */
    public GenieMenu(MagicLamp lamp, Genie genie) {
        this.lamp = lamp;
        this.genie = genie;
    }

    @Override
    protected void printMenu() {
        MenuHelper.printTopLimit("genie menu");
        MenuHelper.printTopLimit(genie.getType(), ".", "");
        System.out.println("1 - Make a wish");
        System.out.println("2 - Available wishes");
        System.out.println("3 - Number of granted wishes");
        if (genie.getWishes().size() > 0) {
            System.out.println("4 - Granted wishes");
        }
        if (genie instanceof Demon) {
            System.out.println("5 - Recharge MagicLamp with Demon");
        }
        System.out.println("0 - Back to Lamp Menu");
        MenuHelper.printBottomLimit();
    }

    /**
     * Requests a menu option choice and handles it. Handles invalid choices by calling {@link
     * ExceptionHelper#handleInputException()}.
     */
    @Override
    protected void handleMenuOption(int option) {
        switch (option) {
            case 1 -> {
                System.out.println("Make a wish: ");
                Scanner sc = new Scanner(System.in);
                String wish = sc.nextLine();
                genie.grantWish(wish);
            }
            case 2 -> MenuHelper.printOptionResponse(
                "Available wish(es): " + MenuHelper.toSingleCase(genie.getAvailableWishes()));
            case 3 -> MenuHelper.printOptionResponse("Granted wish(es): " + genie.getGrantedWishes());
            case 4 -> printGrantedWishes();
            case 5 -> {
                if (genie instanceof Demon demon) {
                    lamp.recharge(demon);
                    MenuHelper.printOptionResponse("You have recharged this MagicLamp. Mother Nature thanks you!");
                    exitMenu();
                }
            }
            case 0 -> exitMenu();
            default -> ExceptionHelper.handleInputException();
        }
    }

    /**
     * Prints the selected genie's list of granted wishes.
     */
    private void printGrantedWishes() {
        MenuHelper.printTopLimit("granted wishes", "'");
        MenuHelper.printTopLimit(genie.getType(), ".", "");
        genie.getWishes().forEach(System.out::println);
        MenuHelper.printBottomLimit("'");
    }

}
