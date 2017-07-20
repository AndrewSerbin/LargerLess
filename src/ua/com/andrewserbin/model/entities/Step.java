package ua.com.andrewserbin.model.entities;

/**
 * Created by admin on 18.07.2017.
 */
public class Step {

    private int number;
    private int userValue;
    private int position;

    public Step() {}

    public Step(int number, int userValue, int position) {
        this.number = number;
        this.userValue = userValue;
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getUserValue() {
        return userValue;
    }

    public void setUserValue(int userValue) {
        this.userValue = userValue;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "number=" + number + ", userValue=" + userValue +
                ", position=" + position + "\n";
    }
}
