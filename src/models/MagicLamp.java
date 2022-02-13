package models;

import helpers.MenuHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that represents the MagicLamp that withholds the genies.
 */
public class MagicLamp {

    /**
     * Auto-incremented counter id.
     */
    private static int idCounter = 1;

    /**
     * Unique id implemented by the attribute idCounter.
     */
    private final int id;

    /**
     * Number of genies the MagicLamp will create.
     */
    private final int originalLimit;

    /**
     * Initially based on originalLimit. Increases when the lamp is recharged to allow further genies to be created.
     */
    private int genieLimit;

    /**
     * Number of genies released by the MagicLamp.
     */
    private int genieCounter;

    /**
     * Number of times the MagicLamp has been rubbed.
     */
    private int rubCounter;

    /**
     * Number of times the MagicLamp has been recharged.
     */
    private int rechargeCounter;

    /**
     * List of the released genies.
     */
    private final List<Genie> genies = new ArrayList<>();

    /**
     * Requires the number of genies be created by the MagicLamp.
     *
     * @param genieLimit number of genies the MagicLamp will release.
     */
    public MagicLamp(int genieLimit) {
        this.genieLimit = genieLimit;
        this.originalLimit = genieLimit;

        this.id = idCounter;
        idCounter++;

        MenuHelper.printOptionResponse("You created a MagicLamp with " + genieLimit + " Genie(s)!");
    }

    /**
     * Requires the number wishes that are expected to be granted.
     * Based on the {@code rubCounter} attribute or the lamps' {@link MagicLamp#getAvailableGenies()} method, creates a new instance and returns a specific {@link Genie} subclass.
     *
     * @param expectedWishCount number of wishes that is expected the Genie to grant
     * @return a {@link Genie} subclass. When {@link MagicLamp#getAvailableGenies()} is lower than 1, returns a {@link Demon}. Otherwise, it returns a {@link GrumpyGenie} when {@code rubCounter} is even, and a {@link HappyGenie} when it is odd.
     */
    public Genie rub(int expectedWishCount) {
        if (getAvailableGenies() < 1) {
            rubCounter++;
            Demon demon = new Demon(expectedWishCount);
            genies.add(demon);
            return demon;
        }

        if (rubCounter % 2 == 0) {
            rubCounter++;
            genieCounter++;
            GrumpyGenie grumpyGenie = new GrumpyGenie(expectedWishCount);
            genies.add(grumpyGenie);
            return grumpyGenie;
        }

        rubCounter++;
        genieCounter++;
        HappyGenie happyGenie = new HappyGenie(expectedWishCount);
        genies.add(happyGenie);
        return happyGenie;
    }

    /**
     * Requires a {@link Demon} and feeds it to the {@link MagicLamp} to recharge it. Removes the {@link Demon} from the Genie list ({@code genies}).
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
     * @return MagicLamp's attributes and its respective values.
     */
    @Override
    public String toString() {
        return "MagicLamp " + id + " [available genies: " + getAvailableGenies() + ", recharge(s): " + rechargeCounter + ", genie(s) released: " + genieCounter + ", rubs(s): " + rubCounter + "]";
    }

    /**
     * Calculates how many genies are available in the MagicLamp based on two class attributes : created genies and released genies.
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
