package ua.com.andrewserbin.model.utils;

import ua.com.andrewserbin.model.Constants;

/**
 * Created by admin on 20.07.2017.
 */
public class RandomGenerator {

    /**
     * Generates random value in range from RAND_MIN + 1 to RAND_MAX - 1
     * Test ignored.
     * @return random value
     */
    public static int rand() {
        return (Constants.RAND_MIN + 1) + (int)(Math.random() * (Constants.RAND_MAX - Constants.RAND_MIN - 1));
    }

    /**
     * Generates random value in range from min + 1 to max - 1
     * Test ignored.
     * @param min
     * @param max
     * @return random value
     */
    public static int rand(int min, int max) {
        return (min + 1) + (int)(Math.random() * (max - min - 1));
    }
}
