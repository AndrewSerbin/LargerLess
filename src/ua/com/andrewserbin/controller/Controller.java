package ua.com.andrewserbin.controller;

import ua.com.andrewserbin.model.Model;
import ua.com.andrewserbin.view.View;
import java.util.Scanner;

/**
 * Created by admin on 18.07.2017.
 */
public class Controller {

    // Constructor
    Model model;
    View view;

    public Controller(Model model, View view) {
        this.model  = model;
        this.view = view;
    }

    /**
     * Gets value from user. Sends request to Model about user
     * value position relatively random selected number. Sends
     * information to Model statistic. Sends to View value position.
     */
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        int stepNumber = 0;
        do {
            model.createCurrentStep();

            model.setUserValue(inputIntValueWithScanner(sc));
            model.setStepNumber(stepNumber);
            model.findPosistionAndSetRange();

            model.addInformationInStatistics();
            stepNumber++;

            switch (model.getPosition()) {
                case Model.POSITION_LARGER:
                    view.printMessage(view.LARGER);
                    break;

                case Model.POSITION_LESS:
                    view.printMessage(view.LESS);
                    break;

                case Model.POSITION_EQUALS:
                    view.printMessage(view.EQUALS + view.END_GAME + view.STATISTICS);
                    view.printMessage(model.getStatistics());
                    break;

                default:
                    view.printMessage(view.ERROR);
                    break;
            }
        } while (model.getPosition() != model.POSITION_EQUALS);
    }

    /**
     * Gets data from user. Checks inputed data for type and range.
     * If data isn't correct, sends an error message to View. Input will be
     * repeated until the validation is completed.
     * @param sc
     * @return user value
     */
    public int inputIntValueWithScanner(Scanner sc) {
        view.printMessage(view.RANGE + model.getRange() + view.INPUT_INT_DATA);

        int userValue;
        while (true) {
            if (sc.hasNextInt()) {
                userValue = sc.nextInt();

                if (model.checkRange(userValue)) {
                    break;
                }
            } else {
                sc.next();
            }

            view.printMessage(view.WRONG_INPUT + view.RANGE + model.getRange() +
                    view.INPUT_INT_DATA);
        }

        return userValue;
    }
}
