package models;

import helpers.MenuHelper;

import java.util.ArrayList;
import java.util.List;

public class MagicLamp {

    private static int idCounter = 1;

    private final int id;
    private final int originalLimit;
    private int genieLimit;
    private int genieCounter;
    private int rubCounter;
    private int rechargeCounter;
    private final List<Genie> genies = new ArrayList<>();

    public MagicLamp(int genieLimit) {
        this.genieLimit = genieLimit;
        this.originalLimit = genieLimit;

        this.id = idCounter;
        idCounter++;

        MenuHelper.printOptionResponse("You created a MagicLamp with " + genieLimit + " Genie(s)!");
    }

    /**
     * Receives a number of wishes. Based on the rub counter attribute, instances a specific Genie subclass.
     *
     * @param expectedWishCount number of wishes that is expected the Genie to grant.
     */
    public void rub(int expectedWishCount) {
        if (getAvailableGenies() < 1) {
            rubCounter++;
            Demon demon = new Demon(expectedWishCount);
            genies.add(demon);
            return;
        }

        if (rubCounter % 2 == 0) {
            rubCounter++;
            genieCounter++;
            GrumpyGenie grumpyGenie = new GrumpyGenie(expectedWishCount);
            genies.add(grumpyGenie);
            return;
        }

        rubCounter++;
        genieCounter++;
        HappyGenie happyGenie = new HappyGenie(expectedWishCount);
        genies.add(happyGenie);
    }

    /**
     * Receives a Demon, feeds it to the MagicLamp to recharge it. Removes the Demon from the Genie list.
     *
     * @param demon Demon
     */
    public void recharge(Demon demon) {
        rechargeCounter++;
        genieLimit += originalLimit;
        demon.setFedToMagicLamp(true);
        genies.remove(demon);
    }

    /**
     * Indicates whether there are any created genies.
     *
     * @return true if there are created genies; false otherwise.
     */
    public boolean hasGenies() {
        return genies.size() > 0;
    }

    /**
     * Overrides the toSting() java.utils method.
     *
     * @return Genie's attributes and its respective values.
     */
    @Override
    public String toString() {
        return "MagicLamp " + id + " [available genies: " + getAvailableGenies() + ", recharge(s): " + rechargeCounter + ", genie(s) released: " + genieCounter + ", rubs(s): " + rubCounter + "]";
    }

    /**
     * Calculates how many genies are available in the MagicLamp based on two class attributes : Created genies and released genies.
     *
     * @return Difference between Genies created and Genies released.
     */
    public int getAvailableGenies() {
        return genieLimit - genieCounter;
    }

    // --------------------
    // Getters and Setters |
    // --------------------

    public int getId() {
        return id;
    }

    public int getRechargeCounter() {
        return rechargeCounter;
    }

    public int getGenieCounter() {
        return genieCounter;
    }

    public List<Genie> getGenies() {
        return genies;
    }

}
