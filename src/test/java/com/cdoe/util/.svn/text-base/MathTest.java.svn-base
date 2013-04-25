package com.cdoe.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tony Ford
 */
public class MathTest {
    
    public MathTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of roundTwoDecimalPlaces method, of class Math.
     */
    @Test
    public void testRoundTwoDecimalPlaces() {
        System.out.println("roundTwoDecimalPlaces");
        double value = 4123.777777;
        double expResult = 4123.78;
        double result = Math.roundTwoDecimalPlaces(value);
        
        System.out.println("rounded : " + result);
        
        assertEquals(expResult, result, 0.0);
        
    }
    /**
     * Test of roundTwoDecimalPlaces method, of class Math.
     */
    @Test
    public void test2RoundTwoDecimalPlaces() {
        System.out.println("roundTwoDecimalPlaces");
        double value = 781254123.777777;
        double expResult = 781254123.78;
        double result = Math.roundTwoDecimalPlaces(value);
        
        System.out.println("rounded : " + result);
        
        assertEquals(expResult, result, 0.0);
        
    }
}
