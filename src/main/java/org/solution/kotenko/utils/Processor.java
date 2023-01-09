package org.solution.kotenko.utils;

import java.io.*;

/**
 * Data evaluator
 */
public class Processor extends Configurations {

    /**
     * Read data from input.txt, reverse if it fibonacci and write result to output.txt
     */
    public static void processor() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(INPUT_PATH));
             FileWriter fileWriter = new FileWriter(OUTPUT_PATH, true)) {
            String line;
            while ((line=bufferedReader.readLine())!=null){
                if (Utils.isFibonacci(line)){
                    fileWriter.write(Utils.reverseSequence(line) + "\n");
                } else {
                    fileWriter.write(line + "\n");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
