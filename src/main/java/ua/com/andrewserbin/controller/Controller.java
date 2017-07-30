package ua.com.andrewserbin.controller;

import ua.com.andrewserbin.model.ModelConstants;
import ua.com.andrewserbin.model.Model;
import ua.com.andrewserbin.model.entities.Range;
import ua.com.andrewserbin.view.View;
import ua.com.andrewserbin.view.ViewConstants;

import java.util.Scanner;

/**
 * Created by admin on 18.07.2017.
 */
public class Controller {

    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    /**
     * Gets value from user. Sends request to Model about user
     * value position relatively random selected number. Sends
     * to View value position.
     */
    public void processUser() {
        Scanner sc = new Scanner(System.in);

        model.setRandomSelectedValue();
        model.setRange();

        while (!model.checkUserValuePosition(inputIntValueWithScanner(sc, model.getRange()))) {
            switch (model.getPosition()) {
                case ModelConstants.POSITION_LARGER:
                    view.printMessage(getMessageFromBundle(ViewConstants.LARGER));
                    break;

                case ModelConstants.POSITION_LESS:
                    view.printMessage(getMessageFromBundle(ViewConstants.LESS));
                    break;

                default:
                    view.printMessage(getMessageFromBundle(ViewConstants.ERROR));
                    break;
            }
        }

        view.printMessage(getMessageFromBundle(ViewConstants.EQUALS), getMessageFromBundle(ViewConstants.END_GAME),
                getMessageFromBundle(ViewConstants.STATISTICS), model.getStatistics());
    }

    /**
     * Gets data from user. Checks inputted data for type and range.
     * If data isn't correct, sends an error message to View. Input will be
     * repeated until the validation is completed.
     * @param sc
     * @return user value
     */
    public int inputIntValueWithScanner(Scanner sc, Range range) {
        String rangeString = getMessageFromBundle(ViewConstants.RANGE);
        String inputIntData = getMessageFromBundle(ViewConstants.INPUT_INT_DATA);
        String wrongInput = getMessageFromBundle(ViewConstants.WRONG_INPUT);

        view.printMessage(rangeString, model.getRange().toString(), inputIntData);

        int userValue;
        while (true) {
            while (!sc.hasNextInt()) {
                view.printMessage(wrongInput, rangeString, model.getRange().toString(),
                        inputIntData);
                sc.next();
            }

            userValue = sc.nextInt();
            if (range.isInRange(userValue)) {
                break;
            } else {
                view.printMessage(wrongInput, rangeString, model.getRange().toString(),
                        inputIntData);
            }

        }

        return userValue;
    }

    private String getMessageFromBundle(String propertyName) {
        return view.getBundle().getString(propertyName);
    }
}
