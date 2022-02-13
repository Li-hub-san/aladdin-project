package models;

import helpers.MenuHelper;

public class HappyGenie extends Genie {
    public HappyGenie(int wishLimit) {
        super(wishLimit);
    }

    /**
     * @return String - Genie subclass
     */
    @Override
    public String getType() {
        return "Happy Genie";
    }

    /**
     * Receives a wish, verifies whether it can be granted and grants it. Prints a response for either case.
     *
     * @param wish wish to be granted.
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

    @Override
    public String toString() {
        return getType() + super.toString();
    }
}
