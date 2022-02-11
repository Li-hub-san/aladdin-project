package models;

import helpers.MenuHelper;

import java.util.Scanner;

public class HappyGenie extends Genie {
    public HappyGenie(int wishLimit) {
        super(wishLimit);
    }

    @Override
    public void grantWish() {
        if (this.wishLimit > this.wishCounter) {
            System.out.println("Make a wish: ");

            Scanner sc = new Scanner(System.in);
            String wish = sc.nextLine();
            // desejos.add(wish);
            wishCounter++;
            MenuHelper.printOptionResponse("Wish '" + wish + "' granted, " + getAvailableWishes() + " wish(es) left!");
        } else {
            MenuHelper.printOptionResponse("No wishes left!");
        }
    }

    @Override
    protected String getType() {
        return "Happy Genie";
    }

    @Override
    public String toString() {
        return getType() + super.toString();
    }
}
