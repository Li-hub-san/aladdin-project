package models;

import helpers.MenuHelper;

import java.util.Scanner;

public class Demon extends Genie {
    private boolean fedToMagicLamp = false;

    public Demon(int wishLimit) {
        super(Integer.MAX_VALUE);
    }

    @Override
    protected String getType() {
        return "Demon";
    }

    public void setFedToMagicLamp(boolean fedToMagicLamp) {
        this.fedToMagicLamp = fedToMagicLamp;
    }

    @Override
    public void grantWish() {
        if (!fedToMagicLamp) {
            System.out.println("Make a wish: ");

            Scanner sc = new Scanner(System.in);
            String wish = sc.nextLine();
            wishCounter++;
            MenuHelper.printOptionResponse("Wish '" + wish + "' granted!");
        } else {
            MenuHelper.printOptionResponse("You have used the Demon to recharge the MagicLamp. There are no more wishes left to grant.");
        }
    }

    @Override
    public String toString() {
        return getType() + super.toString();
    }
}
