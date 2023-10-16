/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import romannumeral.RomanNumeral;

/**
 *
 * @author Salim
 */

public class NumeralTest {

    @Test
    public void singleDigit() {
        assertEquals(1, new RomanNumeral().romanToInt("I"));
        assertEquals(5, new RomanNumeral().romanToInt("V"));
        assertEquals(10, new RomanNumeral().romanToInt("X"));
        assertEquals(50, new RomanNumeral().romanToInt("L"));
        assertEquals(100, new RomanNumeral().romanToInt("C"));
        assertEquals(500, new RomanNumeral().romanToInt("D"));
        assertEquals(1000, new RomanNumeral().romanToInt("M"));
    }

    @Test
    public void repetition() {
        assertEquals(2, new RomanNumeral().romanToInt("II"));
        assertEquals(3, new RomanNumeral().romanToInt("III"));
        assertEquals(20, new RomanNumeral().romanToInt("XX"));
    }

    @Test
    public void manyLettersInOrder() {
        assertEquals(11, new RomanNumeral().romanToInt("XI"));
        assertEquals(21, new RomanNumeral().romanToInt("XXI"));
        // Add more tests for other combinations.
    }

    @Test
    public void subtractiveNotation() {
        assertEquals(4, new RomanNumeral().romanToInt("IV"));
        // Add more tests for other subtractive notations.
    }

    @Test
    public void withAndWithoutSubtractiveNotation() {
        assertEquals(14, new RomanNumeral().romanToInt("XIV"));
        // Add more tests for other combinations.
    }

    @Test
    public void invalidLetters() {
        try {
            new RomanNumeral().romanToInt("Z");
            fail("Not A Valid Roman Number");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void invalidAndValidLetters() {
        try {
            new RomanNumeral().romanToInt("XIZ");
            fail("Wrong Roman Number format Used");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void notValid() {
        try {
            new RomanNumeral().romanToInt("VV");
            fail("Invalid Roman Number");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

    @Test
    public void nullInput() {
        try {
            new RomanNumeral().romanToInt(null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }
}