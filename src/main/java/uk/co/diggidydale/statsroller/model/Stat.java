package uk.co.diggidydale.statsroller.model;

/**
 * @author DaleH
 */
public class Stat {

    private int roll;

    private int bonus;

    public Stat(int roll, int bonus) {
        this.roll = roll;
        this.bonus = bonus;
    }

    public Stat(int roll){
        this(roll, (roll-10)/2);
    }

    public int getRoll() {
        return roll;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}
