package models;

import helpers.MenuHelper;

/**
 * Class that extends the abstract class Genie.
 */
public class HappyGenie extends Genie {

    /**
     * Requires the number wishes that are expected to be granted.
     * It is the only type of Genie that grants all the requested wishes.
     *
     * @param wishLimit number of wishes that is expected to be granted
     */
    public HappyGenie(int wishLimit) {
        super(wishLimit);
    }

    @Override
    public String getType() {
        return "Happy Genie";
    }

    /**
     * Receives a wish, verifies whether it can be granted and grants it. Prints a response for either case.
     *
     * @param wish wish to be granted
     */
    @Override
    public void grantWish(String wish) {
        if (this.wishLimit > this.wishCounter) {
            wishes.add(wish);
            wishCounter++;
            MenuHelper.printOptionResponse("Wish '" + wish + "' granted, " + getAvailableWishes() + " wish(es) left!");
        } else {
            MenuHelper.printOptionResponse("No wishes left!");
        }
    }

}
