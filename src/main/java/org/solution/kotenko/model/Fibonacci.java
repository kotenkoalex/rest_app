package org.solution.kotenko.model;

/**
 * Represent fibonacci instance
 */
public class Fibonacci {

    /**
     * Sequence (could be fibonacci or not)
     */
    private String num;

    /**
     * Constructor with parameter
     *
     * @param num takes num
     */
    public Fibonacci(String num) {
        this.num = num;
    }

    /**
     * Getter
     *
     * @return num
     */
    public String getNum() {
        return num;
    }
}
