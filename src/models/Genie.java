package models;

public abstract class Genie {
    protected int wishLimit;
    protected int wishCounter;

    public Genie(int wishLimit) {
        this.wishLimit = wishLimit;
        System.out.println("A " + this.getType() + " appears before you!");
    }

    protected abstract String getType();

    public int getGrantedWishes() {
        return wishCounter;
    }

    public int getAvailableWishes() {
        return wishLimit - wishCounter;
    }

    public abstract void grantWish();

    @Override
    public String toString() {
        return " [wishLimit: " + wishLimit +
                ", wishCounter: " + wishCounter +
                ']';
    }
}
