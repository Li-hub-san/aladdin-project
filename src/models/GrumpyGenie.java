package models;

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
            System.out.println("** Wish '" + wish + "' granted, " + getAvailableWishes() + " wish(es) left **");
        } else {
            System.out.println("No wishes left!");
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
        return "Grumpy" + super.toString();
    }
}
