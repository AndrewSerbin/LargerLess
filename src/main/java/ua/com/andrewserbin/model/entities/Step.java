package ua.com.andrewserbin.model.entities;

/**
 * Created by admin on 18.07.2017.
 */
public class Step {

    private int userValue;
    private int position;

    public Step() {}

    public Step(int userValue, int position) {
        this.userValue = userValue;
        this.position = position;
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
        return "userValue=" + userValue + ", position=" + position;
    }
}
