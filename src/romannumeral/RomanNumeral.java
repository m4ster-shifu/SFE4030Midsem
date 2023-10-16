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
        int prevNumber = 0;  // To track the previous number while iterating

        for (int i = s.length() - 1; i >= 0; i--) {
            int currentNumber = map.getOrDefault(s.charAt(i), 0);

            // If the current number is greater than or equal to the previous number, add it
            if (currentNumber >= prevNumber) {
                convertedNumber += currentNumber;
            } else {
                // If the current number is smaller than the previous number, subtract it
                convertedNumber -= currentNumber;
            }

            // Update the previous number for the next iteration
            prevNumber = currentNumber;
        }

        return convertedNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a Roman numeral: ");
        String input = scanner.nextLine().trim().toUpperCase();  // Convert input to uppercase

        RomanNumeral romanNumeral = new RomanNumeral();

        try {
            int result = romanNumeral.romanToInt(input);
            System.out.println("Converted to Integer: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}