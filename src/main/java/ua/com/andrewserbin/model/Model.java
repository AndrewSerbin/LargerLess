package ua.com.andrewserbin.model;

import ua.com.andrewserbin.model.entities.Range;
import ua.com.andrewserbin.model.entities.Step;
import ua.com.andrewserbin.model.utils.RandomGenerator;
import java.util.ArrayList;

/**
 * Created by admin on 18.07.2017.
 */
public class Model {

    private Range range;

    private ArrayList<Step> statistics;
    private Step currentStep;

    private int randomSelectedValue;

    public Model() {
        statistics = new ArrayList<>();
    }

    /**
     * Checks position of user value relatively random selected value.
     * Adds infromation in statistics.
     * @param userValue
     * @return flag game over or not
     */
    public boolean checkUserValuePosition(int userValue) {
        createCurrentStep();

        setUserValue(userValue);
        setPosition(findPosistionAndSetRange());

        addInformationInStatistics();

        return getPosition() == Constants.POSITION_EQUALS;
    }

    /**
     * Finds position of user value relatively random selected value.
     * Sets new range with user value and position.
     * @return position
     */
    public int findPosistionAndSetRange() {
        if (currentStep.getUserValue() > randomSelectedValue) {
            range.setEnd(currentStep.getUserValue());

            return Constants.POSITION_LARGER;
        } else if (currentStep.getUserValue() < randomSelectedValue) {
            range.setStart(currentStep.getUserValue());

            return Constants.POSITION_LESS;
        } else {
            return Constants.POSITION_EQUALS;
        }
    }

    public void setRandomSelectedValue() {
        randomSelectedValue = RandomGenerator.rand();;
    }

    public int getRandomSelectedValue() {
        return randomSelectedValue;
    }

    public void addInformationInStatistics() {
        statistics.add(currentStep);
    }

    public Range getRange() {
        return range;
    }

    public void setRange() {
        range = new Range(Constants.DEFAULT_RANGE_MIN, Constants.DEFAULT_RANGE_MAX);
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

    public void createCurrentStep() {
        currentStep = new Step();
    }
}
