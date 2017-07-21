package ua.com.andrewserbin.model.utils;

import org.junit.Ignore;
import org.junit.Test;
import ua.com.andrewserbin.model.Constants;
import static org.junit.Assert.*;

/**
 * Created by admin on 21.07.2017.
 */
public class RandomGeneratorTest {

    public static final int CYCLE_RANDOM = 1000;

    @Ignore
    @Test
    public void randWithDefaultEndsTest() throws Exception {
        for (int i = 0; i < CYCLE_RANDOM; i++) {
            int res = RandomGenerator.rand();

            boolean isEndsSelected = (res >= Constants.RAND_MAX) || (res <= Constants.RAND_MIN);
            assertFalse(isEndsSelected);
        }
    }

    @Ignore
    @Test
    public void randWithUserEndsTest() throws Exception {
        int min = 10;
        int max = 30;

        for (int i = 0; i < CYCLE_RANDOM; i++) {
            int res = RandomGenerator.rand(min, max);

            boolean isEndsSelected = (res >= max) || (res <= min);
            assertFalse(isEndsSelected);
        }
    }
}