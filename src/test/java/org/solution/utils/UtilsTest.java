package org.solution.utils;

import org.solution.kotenko.utils.Utils;

import static org.junit.Assert.*;

public class UtilsTest {

    String numCorrect = "1, 1, 2, 3, 5, 8";
    String numWrong = "1, 1, 2, 3, 5, 7";

    @org.junit.Test
    public void isFibonacciCorrect() {
        boolean expected = true;
        boolean actual = Utils.isFibonacci(numCorrect);
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void isFibonacciWrong() {
        boolean expected = false;
        boolean actual = Utils.isFibonacci(numWrong);
        assertEquals(expected, actual);
    }

    @org.junit.Test
    public void reverseSequence() {
        StringBuilder stringBuilder = new StringBuilder(numCorrect);
        String expected = stringBuilder.reverse().toString().replace(" ", "");
        String actual = Utils.reverseSequence(numCorrect).replace(" ", "");
        assertEquals(expected, actual);
    }
}