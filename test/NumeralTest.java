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
        assertEquals(100, new RomanNumeral().romanToInt("C"));
        assertEquals(200, new RomanNumeral().romanToInt("CC"));
    }

    @Test
    public void subtractiveNotation() {
        assertEquals(4, new RomanNumeral().romanToInt("IV"));
        assertEquals(9, new RomanNumeral().romanToInt("IX"));
        assertEquals(40, new RomanNumeral().romanToInt("XL"));
    }

    @Test
    public void withAndWithoutSubtractiveNotation() {
        assertEquals(14, new RomanNumeral().romanToInt("XIV"));
        assertEquals(99, new RomanNumeral().romanToInt("XCIX"));
    }

    @Test
    public void invalidLetters() {
        try {
            new RomanNumeral().romanToInt("Z");
            fail("Not A Valid Roman Number");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Roman numeral: Z", e.getMessage());
        }
    }

    @Test
    public void invalidAndValidLetters() {
        try {
            new RomanNumeral().romanToInt("XIZ");
            fail("Wrong Roman Number format Used");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Roman numeral: XI", e.getMessage());
        }
    }

    @Test
    public void notValid() {
        try {
            new RomanNumeral().romanToInt("VV");
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid Roman numeral: VV", e.getMessage());
        }
    }

    @Test
    public void nullInput() {
        try {
            new RomanNumeral().romanToInt(null);
            fail("Expected IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Input cannot be null or empty", e.getMessage());
        }
    }
}