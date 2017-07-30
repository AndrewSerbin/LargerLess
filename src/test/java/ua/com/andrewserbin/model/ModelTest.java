package ua.com.andrewserbin.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by admin on 22.07.2017.
 */
public class ModelTest {

    private Model model;

    @Before
    public void initModel() {
        model = new Model();
        model.setRandomSelectedValue();
        model.setRange();
    }

    @Test
    public void testFindLargerPosistion() throws Exception {
        int userValue = model.getRandomSelectedValue() + 1;

        model.createCurrentStep();
        model.setUserValue(userValue);

        assertEquals(ModelConstants.POSITION_LARGER, model.findPosistionAndSetRange());
    }

    @Test
    public void testFindLessPosistion() throws Exception {
        int userValue = model.getRandomSelectedValue() - 1;

        model.createCurrentStep();
        model.setUserValue(userValue);

        assertEquals(ModelConstants.POSITION_LESS, model.findPosistionAndSetRange());
    }

    @Test
    public void testFindEqualsPosistion() throws Exception {
        int userValue = model.getRandomSelectedValue();

        model.createCurrentStep();
        model.setUserValue(userValue);

        assertEquals(ModelConstants.POSITION_EQUALS, model.findPosistionAndSetRange());
    }

    @Test
    public void checkUserValueEqualsPosition() throws Exception {
        int userValue = model.getRandomSelectedValue();

        assertTrue(model.checkUserValuePosition(userValue));
    }

    @Test
    public void checkUserValueNotEqualsPosition() throws Exception {
        int userValue = model.getRandomSelectedValue() + 1;

        assertFalse(model.checkUserValuePosition(userValue));
    }

}