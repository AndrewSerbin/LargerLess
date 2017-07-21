package ua.com.andrewserbin.controller;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

/**
 * Created by admin on 21.07.2017.
 */
public class ControllerTest {

    private Scanner sc;

    @Before
    public void initScanner() {
        String source = "4";

        sc = new Scanner(source);
    }

    @Test
    public void testInputIntValueWithScanner() throws Exception {
        int value = sc.nextInt();

        Assert.assertEquals(value, 4);
    }

}