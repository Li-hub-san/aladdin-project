package models;

import java.util.ArrayList;
import java.util.List;

public class MagicLamp {
    private final int genieLimit;
    private int genieCounter;
    private int rubCounter;
    private int rechargeCounter;
    private List<Genie> genies = new ArrayList<>();

    public MagicLamp(int genieLimit) {
        this.genieLimit = genieLimit;
        System.out.println("You created a Magic Lamp!");
    }

    public int getRechargeCounter() {
        return rechargeCounter;
    }

    public int getAvailableGenies() {
        return genieLimit - genieCounter;
    }

    public int getGenieCounter() {
        return genieCounter;
    }

    public void setGenieCounter(int genieCounter) {
        this.genieCounter = genieCounter;
    }

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

    public void recharge(Demon demon) {
        rechargeCounter++;
        genieCounter = 0;
        demon.setFedToMagicLamp(true);
    }

    @Override
    public String toString() {
        return "MagicLamp [genie limit: " + genieLimit + ", recharge(s): " + rechargeCounter +
                ", genie(s) released: " + genieCounter + ", rubs(s): " + rubCounter + "]";
    }

    public List<Genie> getGenies() {
        return genies;
    }

    public boolean hasGenies() {
        return genies.size() > 0;
    }
}
