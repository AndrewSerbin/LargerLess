package ua.com.andrewserbin.controller;

import ua.com.andrewserbin.model.Constants;
import ua.com.andrewserbin.model.Model;
import ua.com.andrewserbin.model.entities.Range;
import ua.com.andrewserbin.view.View;
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
     * information to Model statistic. Sends to View value position.
     */
    public void processUser() {
        Scanner sc = new Scanner(System.in);

        model.setRandomSelectedValue();
        model.setRange();

        while (!model.checkUserValuePosition(inputIntValueWithScanner(sc, model.getRange()))) {
            switch (model.getPosition()) {
                case Constants.POSITION_LARGER:
                    view.printMessage(view.LARGER);
                    break;

                case Constants.POSITION_LESS:
                    view.printMessage(view.LESS);
                    break;

                default:
                    view.printMessage(view.ERROR);
                    break;
            }
        }

        view.printMessage(view.EQUALS, view.END_GAME, view.STATISTICS, model.getStatistics());
    }

    /**
     * Gets data from user. Checks inputed data for type and range.
     * If data isn't correct, sends an error message to View. Input will be
     * repeated until the validation is completed.
     * @param sc
     * @return user value
     */
    public int inputIntValueWithScanner(Scanner sc, Range range) {
        view.printMessage(view.RANGE, model.getRange().toString(), view.INPUT_INT_DATA);

        int userValue;
        while (true) {
            while (!sc.hasNextInt()) {
                view.printMessage(view.WRONG_INPUT, view.RANGE, model.getRange().toString(),
                        view.INPUT_INT_DATA);
                sc.next();
            }

            userValue = sc.nextInt();
            if (range.check(userValue)) {
                break;
            } else {
                view.printMessage(view.WRONG_INPUT, view.RANGE, model.getRange().toString(),
                        view.INPUT_INT_DATA);
            }

        }

        return userValue;
    }
}
