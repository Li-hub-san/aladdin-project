package models;

import helpers.MenuHelper;

public class Demon extends Genie {
    private boolean fedToMagicLamp = false;

    public Demon(int wishLimit) {
        super(wishLimit);
    }

    @Override
    public String getType() {
        return "Demon";
    }

    @Override
    public double getAvailableWishes() {
        if (fedToMagicLamp) {
            return 0;
        }
        return Double.POSITIVE_INFINITY;
    }

    public void setFedToMagicLamp(boolean fedToMagicLamp) {
        this.fedToMagicLamp = fedToMagicLamp;
    }

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
}
