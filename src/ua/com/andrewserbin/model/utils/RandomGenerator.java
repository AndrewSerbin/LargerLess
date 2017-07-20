package ua.com.andrewserbin.model.utils;

/**
 * Created by admin on 20.07.2017.
 */
public class RandomGenerator {

    public static final int RAND_MAX = 100;
    public static final int RAND_MIN = 0;

    /**
     * Generates random value in range from RAND_MIN to RAND_MAX
     * @return random value
     */
    public static int rand() {
        return RAND_MIN + (int) (Math.random() * RAND_MAX);
    }

    /**
     * Generates random value in range from min to max
     * @param min
     * @param max
     * @return
     */
    public static int rand(int min, int max) {
        return min + (int) (Math.random() * max);
    }
}
