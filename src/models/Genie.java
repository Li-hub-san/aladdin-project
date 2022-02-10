package models;

import helpers.MenuHelper;

public abstract class Genie {
    protected int wishLimit;
    protected int wishCounter;

    public Genie(int wishLimit) {
        this.wishLimit = wishLimit;

        MenuHelper.printOptionResponse("A " + this.getType() + " appears before you!");
    }

    protected abstract String getType();

    public int getGrantedWishes() {
        return wishCounter;
    }

    public double getAvailableWishes() {
        return wishLimit - wishCounter;
    }

    public abstract void grantWish();

    @Override
    public String toString() {
        return " [wishLimit: " + wishLimit +
                ", wishCounter: " + wishCounter +
                ']';
    }
}
