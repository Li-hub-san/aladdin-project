package models;

import helpers.MenuHelper;

/**
 * Class that extends the abstract class Genie.
 */
public class GrumpyGenie extends Genie {

    /**
     * Requires the number wishes that are expected to be granted.
     * It is the only type of Genie that overrides the limit to 1.
     *
     * @param wishLimit number of wishes that is expected to be granted (disregarded)
     */
    public GrumpyGenie(int wishLimit) {
        super(1);
    }

    @Override
    public String getType() {
        return "Grumpy Genie";
    }

    /**
     * Receives a wish, verifies whether it can be granted and grants it. Prints a response for either case.
     *
     * @param wish wish to be granted
     */
    @Override
    public void grantWish(String wish) {
        if (!wishHasBeenGranted()) {
            wishes.add(wish);
            wishCounter++;
            MenuHelper.printOptionResponse("Wish '" + wish + "' granted, " + MenuHelper.toSingleCase(getAvailableWishes()) + " wish(es) left!");
        } else {
            MenuHelper.printOptionResponse("No wishes left!");
        }
    }

    /**
     * Verifies if the wish has been granted.
     *
     * @return true if the wish was granted; false otherwise.
     */
    public boolean wishHasBeenGranted() {
        return wishCounter == 1;
    }

}
