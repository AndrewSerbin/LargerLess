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
                    view.printMessage(ViewConstants.LARGER);
                    break;

                case ModelConstants.POSITION_LESS:
                    view.printMessage(ViewConstants.LESS);
                    break;

                default:
                    view.printMessage(ViewConstants.ERROR);
                    break;
            }
        }

        view.printMessage(ViewConstants.EQUALS, ViewConstants.END_GAME, ViewConstants.STATISTICS, model.getStatistics());
    }

    /**
     * Gets data from user. Checks inputted data for type and range.
     * If data isn't correct, sends an error message to View. Input will be
     * repeated until the validation is completed.
     * @param sc
     * @return user value
     */
    public int inputIntValueWithScanner(Scanner sc, Range range) {
        view.printMessage(ViewConstants.RANGE, model.getRange().toString(), ViewConstants.INPUT_INT_DATA);

        int userValue;
        while (true) {
            while (!sc.hasNextInt()) {
                view.printMessage(ViewConstants.WRONG_INPUT, ViewConstants.RANGE, model.getRange().toString(),
                        ViewConstants.INPUT_INT_DATA);
                sc.next();
            }

            userValue = sc.nextInt();
            if (range.isInRange(userValue)) {
                break;
            } else {
                view.printMessage(ViewConstants.WRONG_INPUT, ViewConstants.RANGE, model.getRange().toString(),
                        ViewConstants.INPUT_INT_DATA);
            }

        }

        return userValue;
    }
}
