package ua.com.andrewserbin.model;

import ua.com.andrewserbin.model.entities.Range;
import ua.com.andrewserbin.model.entities.Step;
import ua.com.andrewserbin.model.utils.RandomGenerator;

import java.util.ArrayList;

/**
 * Created by admin on 18.07.2017.
 */
public class Model {

    public static final int POSITION_LARGER = 1;
    public static final int POSITION_EQUALS = 0;
    public static final int POSITION_LESS = -1;

    public static final int DEFAULT_RANGE_MAX = 100;
    public static final int DEFAULT_RANGE_MIN = 0;

    private Range range;

    private ArrayList<Step> statistics;

    private int randomSelectedValue;

    private Step currentStep;

    public Model() {
        randomSelectedValue = RandomGenerator.rand();
        statistics = new ArrayList<>();
        range = new Range(DEFAULT_RANGE_MIN, DEFAULT_RANGE_MAX);
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
        if (currentStep.getUserValue() > randomSelectedValue) {
            range.setEnd(currentStep.getUserValue() - 1);

            return POSITION_LARGER;
        } else if (currentStep.getUserValue() < randomSelectedValue) {
            range.setStart(currentStep.getUserValue() + 1);

            return POSITION_LESS;
        } else {
            return POSITION_EQUALS;
        }
    }

    public void addInformationInStatistics() {
        statistics.add(currentStep);
    }

    public Range getRange() {
        return range;
    }

    public String getStatistics() {
        return statistics.toString();
    }

    public void setUserValue(int userValue) {
        currentStep.setUserValue(userValue);
    }

    public int getPosition() {
        return currentStep.getPosition();
    }

    public void setPosition(int position) {
        currentStep.setPosition(position);
    }

    public void setStepNumber(int stepNumber) {
        currentStep.setNumber(stepNumber);
    }

    public void createCurrentStep() {
        currentStep = new Step();
    }
}
