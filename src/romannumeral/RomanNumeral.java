/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// RomanNumeral.java
package romannumeral;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanNumeral {
    private static Map<Character, Integer> map;

    static {
        map = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
    }

    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty");
        }

        int convertedNumber = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentNumber = map.getOrDefault(s.charAt(i), 0);
            int next = (i + 1 < s.length()) ? map.getOrDefault(s.charAt(i + 1), 0) : 0;

            if (currentNumber >= next) {
                convertedNumber += currentNumber;
            } else {
                convertedNumber -= currentNumber;
            }
        }

        return convertedNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a Roman numeral: ");
        String input = scanner.nextLine().trim();

        RomanNumeral romanNumeral = new RomanNumeral();

        try {
            int result = romanNumeral.romanToInt(input);
            System.out.println("Converted to Integer: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
