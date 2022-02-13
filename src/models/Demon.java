package models;

import helpers.MenuHelper;

public class Demon extends Genie {
    private boolean fedToMagicLamp = false;

    public Demon(int wishLimit) {
        super(wishLimit);
    }

    /**
     * @return String - Genie subclass
     */
    @Override
    public String getType() {
        return "Demon";
    }

    /**
     * Returns the Demon's available wishes. Will always be one of two values: 0 or Infinity.
     *
     * @return the Demon's available wishes.
     */
    @Override
    public double getAvailableWishes() {
        if (fedToMagicLamp) {
            return 0;
        }
        return Double.POSITIVE_INFINITY;
    }

    /**
     * Receives a wish, verifies whether it can be granted and grants it. Prints a response for either case.
     *
     * @param wish wish to be granted.
     */
    @Override
    public void grantWish(String wish) {
        if (!fedToMagicLamp) {
            wishes.add(wish);
            wishCounter++;
            MenuHelper.printOptionResponse("Wish '" + wish + "' granted!");
        } else {
            MenuHelper.printOptionResponse("You have used the Demon to recharge the MagicLamp. There are no more wishes left to grant.");
        }
    }

    @Override
    public String toString() {
        return getType() + " [wishLimit: UNLIMITED" +
                ", wishCounter: " + wishCounter +
                ']';
    }

    // --------------------
    // Getters and Setters |
    // --------------------

    public void setFedToMagicLamp(boolean fedToMagicLamp) {
        this.fedToMagicLamp = fedToMagicLamp;
    }
}
