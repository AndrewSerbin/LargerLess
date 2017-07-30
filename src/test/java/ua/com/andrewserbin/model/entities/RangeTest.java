package ua.com.andrewserbin.model.entities;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ua.com.andrewserbin.model.ModelConstants;

/**
 * Created by admin on 21.07.2017.
 */
public class RangeTest {

    private Range range;

    @Before
    public void initRange() {
        range = new Range(ModelConstants.DEFAULT_RANGE_MIN, ModelConstants.DEFAULT_RANGE_MAX);
    }

    @Test
    public void testCheckInRange() {
        Assert.assertTrue(range.isInRange(5));
    }

    @Test
    public void testCheckOutOfRange() {
        Assert.assertFalse(range.isInRange(110));
    }
}