package ua.com.andrewserbin.model;

import ua.com.andrewserbin.model.entities.Range;
import ua.com.andrewserbin.model.entities.Step;
import ua.com.andrewserbin.model.utils.RandomGenerator;

import java.util.ArrayList;

/**
 * Created by admin on 18.07.2017.
 */
public class Model {

    // Position constants
    public static final int LARGER = 1;
    public static final int EQUALS = 0;
    public static final int LESS = -1;

    private Range range;

    private ArrayList<Step> statistics;

    private int randomSelectedValue;
    private int userValue;

    // Position of user value relatively random selected value
    private int position;

    public Model() {
        randomSelectedValue = RandomGenerator.rand();
        statistics = new ArrayList<>();
        range = new Range(RandomGenerator.RAND_MIN, RandomGenerator.RAND_MAX);
    }

    public boolean checkRange(int userValue) {
        return range.check(userValue);
    }

    /**
     * Finds position of user value relatively random selected value.
     * Sets new range with user value and position.
     * @return position
     */
    public int findPosistionAndSetRange() {
        if (userValue > randomSelectedValue) {
            range.setEnd(userValue - 1);

            position = LARGER;
        } else if (userValue < randomSelectedValue) {
            range.setStart(userValue + 1);

            position = LESS;
        } else {
            position = EQUALS;
        }

        return position;
    }

    public void addInformationInStatistics(int stepNumber) {
        statistics.add(new Step(stepNumber, userValue, position));
    }

    public Range getRange() {
        return range;
    }

    public String getStatistics() {
        return statistics.toString();
    }

    public void setUserValue(int userValue) {
        this.userValue = userValue;
    }

    public int getPosition() {
        return position;
    }
}
