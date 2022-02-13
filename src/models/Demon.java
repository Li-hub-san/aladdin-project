package models;

import helpers.MenuHelper;

/**
 * Class that extends the abstract class Genie.
 * It is the only type of Genie that can recharge the MagicLamp.
 */
public class Demon extends Genie {

    /**
     * Determinate whether the Demon has been fed to the MagicLamp or not.
     * When true, the Demon can not grant any more wishes; otherwise false and the Demon is able to keep granting wishes.
     */
    private boolean fedToMagicLamp = false;

    /**
     * Requires the number wishes that are expected to be granted.
     *
     * @param wishLimit number of wishes that is expected to be granted
     */
    public Demon(int wishLimit) {
        super(wishLimit);
    }


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
     * @param wish wish to be granted
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
