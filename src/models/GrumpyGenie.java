package models;

import helpers.MenuHelper;

import java.util.Scanner;

public class GrumpyGenie extends Genie {
    public GrumpyGenie(int wishLimit) {
        super(1);
    }

    @Override
    public void grantWish() {
        if (!wishHasBeenGranted()) {
            System.out.println("Make a wish: ");

            Scanner sc = new Scanner(System.in);
            String wish = sc.nextLine();
            wishCounter++;
            MenuHelper.printOptionResponse("Wish '" + wish + "' granted, " + getAvailableWishes() + " wish(es) left!");
        } else {
            MenuHelper.printOptionResponse("No wishes left!");
        }
    }

    @Override
    protected String getType() {
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
