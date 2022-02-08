package models;

import java.util.Scanner;

public class Demon extends Genie {
    private boolean fedToMagicLamp = false;

    public Demon(int wishLimit) {
        super(wishLimit);
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
            System.out.println("** Wish '" + wish + "' granted! **");
        } else {
            System.out.println("You have used the Demon to recharge the MagicLamp. There are no more wishes left to grant.");
        }
    }

    @Override
    public String toString() {
        return "Demon {" +
                "wishCounter=" + wishCounter +
                ", fedToMagicLamp=" + fedToMagicLamp +
                '}';
    }
}
