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
    public void testRandWithDefaultEndsForSelectingEnds() throws Exception {
        for (int i = 0; i < CYCLE_RANDOM; i++) {
            int res = RandomGenerator.rand();

            boolean isEndsSelected = (res >= Constants.RAND_MAX) || (res <= Constants.RAND_MIN);
            assertFalse(isEndsSelected);
        }
    }

    @Ignore
    @Test
    public void testRandWithUserEndsForSelectingEnds() throws Exception {
        int min = 10;
        int max = 30;

        for (int i = 0; i < CYCLE_RANDOM; i++) {
            int res = RandomGenerator.rand(min, max);

            boolean isEndsSelected = (res >= max) || (res <= min);
            assertFalse(isEndsSelected);
        }
    }

    @Ignore
    @Test
    public void testRandWithDefaultEndsForSelectingFirstNumber() throws Exception {
        boolean isFirstNumberSelected = false;
        for (int i = 0; i < CYCLE_RANDOM; i++) {
            int res = RandomGenerator.rand();

            isFirstNumberSelected = res == (Constants.RAND_MIN + 1);
            if (isFirstNumberSelected) {
                break;
            }
        }
        assertTrue(isFirstNumberSelected);
    }

    @Ignore
    @Test
    public void testRandWithDefaultEndsForSelectingLastNumber() throws Exception {
        boolean isLastNumberSelected = false;
        for (int i = 0; i < CYCLE_RANDOM; i++) {
            int res = RandomGenerator.rand();

            isLastNumberSelected = res == (Constants.RAND_MAX - 1);
            if (isLastNumberSelected) {
                break;
            }
        }
        assertTrue(isLastNumberSelected);
    }

    @Ignore
    @Test
    public void testRandWithDefaultEndsForSelectingNumberInCenter() throws Exception {
        boolean isNumberInCenterSelected = false;
        for (int i = 0; i < CYCLE_RANDOM; i++) {
            int res = RandomGenerator.rand();

            isNumberInCenterSelected = res == (Constants.RAND_MIN + Constants.RAND_MAX / 2);
            if (isNumberInCenterSelected) {
                break;
            }
        }
        assertTrue(isNumberInCenterSelected);
    }

    @Ignore
    @Test
    public void testRandWithUserEndsForSelectingFirstNumber() throws Exception {
        int min = 10;
        int max = 30;
        boolean isFirstNumberSelected = false;
        for (int i = 0; i < CYCLE_RANDOM; i++) {
            int res = RandomGenerator.rand(min, max);

            isFirstNumberSelected = res == (min + 1);
            if (isFirstNumberSelected) {
                break;
            }
        }
        assertTrue(isFirstNumberSelected);
    }

    @Ignore
    @Test
    public void testRandWithUserEndsForSelectingLastNumber() throws Exception {
        int min = 10;
        int max = 30;
        boolean isLastNumberSelected = false;
        for (int i = 0; i < CYCLE_RANDOM; i++) {
            int res = RandomGenerator.rand(min, max);

            isLastNumberSelected = res == (max - 1);
            if (isLastNumberSelected) {
                break;
            }
        }
        assertTrue(isLastNumberSelected);
    }

    @Ignore
    @Test
    public void testRandWithUserEndsForSelectingNumberInCenter() throws Exception {
        int min = 10;
        int max = 30;
        boolean isNumberInCenterSelected = false;
        for (int i = 0; i < CYCLE_RANDOM; i++) {
            int res = RandomGenerator.rand(min, max);

            isNumberInCenterSelected = res == (min + max / 2);
            if (isNumberInCenterSelected) {
                break;
            }
        }
        assertTrue(isNumberInCenterSelected);
    }
}