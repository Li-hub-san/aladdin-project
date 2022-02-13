package models;

import helpers.MenuHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class from which all the genies extend from.
 */
public abstract class Genie {
    protected int wishLimit;
    protected int wishCounter;
    protected List<String> wishes = new ArrayList<>();

    /**
     * Requires the number wishes that are expected to be granted.
     *
     * @param wishLimit number of wishes that are expected to be granted
     */
    public Genie(int wishLimit) {
        this.wishLimit = wishLimit;

        MenuHelper.printOptionResponse("A " + this.getType() + " appears before you!");
    }

    /**
     * Returns the Genie's type.
     *
     * @return Genie's type.
     */
    public abstract String getType();

    /**
     * Grants a wish.
     *
     * @param wish wish to be granted
     */
    public abstract void grantWish(String wish);

    /**
     * @return Difference between the wish limit and granted wishes.
     */
    public double getAvailableWishes() {
        return wishLimit - wishCounter;
    }

    /**
     * Overrides the toSting() java.utils method.
     *
     * @return Genie's attributes and its respective values.
     */
    @Override
    public String toString() {
        return getType() + " [wishLimit: " + wishLimit + ", wishCounter: " + wishCounter + ']';
    }

    // --------------------
    // Getters and Setters |
    // --------------------

    public int getGrantedWishes() {
        return wishCounter;
    }

    public List<String> getWishes() {
        return wishes;
    }

}
