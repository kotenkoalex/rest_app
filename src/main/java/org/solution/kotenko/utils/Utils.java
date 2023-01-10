package org.solution.kotenko.utils;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Represents utils methods
 */
public class Utils {

    /**
     * Reverse sequence
     *
     * @param num takes string with num sequence
     * @return reversed sequence
     */
    public static String reverseSequence(String num) {
        int[] convert = convert(num);
        StringBuilder result = new StringBuilder();
        for (int i = convert.length - 1; i >= 0; i--) {
            result.append(convert[i]).append(",");
        }
        return result.substring(0, result.length() - 2);
    }

    /**
     * Check current sequence is fibonacci sequence
     *
     * @param num takes string with num sequence
     * @return true if it's fibonacci sequence
     */
    public static boolean isFibonacci(String num) {
        int[] actualSequence = convert(num);
        if (actualSequence.length < 3) {
            return false;
        }
        int first = actualSequence[0];
        int second = actualSequence[1];
        int third = actualSequence[2];
        if ((first + second) != third | first > second) {
            return false;
        }
        int[] expectedSequence = new int[actualSequence.length];
        expectedSequence[0] = first;
        expectedSequence[1] = second;
        IntStream.range(2, expectedSequence.length)
                .forEach(i -> expectedSequence[i] = expectedSequence[i - 1] + expectedSequence[i - 2]);
        return Arrays.equals(actualSequence, expectedSequence);
    }

    /**
     * Convert string to int array
     * delimiter must be only ", "
     *
     * @param num takes string
     * @return int array
     */
    private static int[] convert(String num) {
        return Arrays.stream(num.split(",")).mapToInt(Integer::parseInt).toArray();
    }
}