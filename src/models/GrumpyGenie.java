package models;

import helpers.MenuHelper;

public class GrumpyGenie extends Genie {
    public GrumpyGenie(int wishLimit) {
        super(1);
    }

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

    @Override
    public String getType() {
        return "Grumpy Genie";
    }

    public boolean wishHasBeenGranted() {
        return wishCounter == 1;
    }

    @Override
    public String toString() {
        return getType() + super.toString();
    }
}
