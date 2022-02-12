package models;

import helpers.MenuHelper;

import java.util.ArrayList;
import java.util.List;

public abstract class Genie {
    protected int wishLimit;
    protected int wishCounter;
    protected List<String> wishes = new ArrayList<>();

    public Genie(int wishLimit) {
        this.wishLimit = wishLimit;

        MenuHelper.printOptionResponse("A " + this.getType() + " appears before you!");
    }

    public abstract String getType();

    public int getGrantedWishes() {
        return wishCounter;
    }

    public double getAvailableWishes() {
        return wishLimit - wishCounter;
    }

    public abstract void grantWish(String wish);

    public List<String> getWishes() {
        return wishes;
    }

    @Override
    public String toString() {
        return " [wishLimit: " + wishLimit +
                ", wishCounter: " + wishCounter +
                ']';
    }
}
