package ua.com.andrewserbin.view;

/**
 * Created by admin on 18.07.2017.
 */
public class View {

    // Text's constants
    public static final String INPUT_INT_DATA = "Input INT value = ";
    public static final String WRONG_INPUT = "Wrong input! Repeat please! ";
    public static final String LARGER = "Larger";
    public static final String LESS = "Less";
    public static final String EQUALS = "Equals\n";
    public static final String RANGE = "Range: ";
    public static final String END_GAME = "This game is yours! Congratulations!\n";
    public static final String ERROR = "Error!";
    public static final String STATISTICS = "Statistics:\n";

    /**
     * Prints message in console.
     * @param message
     */
    public void printMessage(String message){
        System.out.println(message);
    }

    /**
     * Concatenates messages and prints them in console.
     * @param messages
     */
    public void printMessage(String... messages) {
        StringBuilder builder = new StringBuilder();

        for (String message :
                messages) {
            builder.append(message);
        }

        System.out.println(builder);
    }

}
