package org.solution.kotenko.data;

import org.solution.kotenko.config.Configurations;
import org.solution.kotenko.model.Fibonacci;
import org.solution.kotenko.utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is singleton and responsible for date storage
 */
public class DataStorage extends Configurations {
    /**
     * Represent storage of data in memory
     */
    private static final List<Fibonacci> FIBONACCI_LIST = new ArrayList<>();

    /**
     * Represent singleton
     */
    private static final DataStorage INSTANCE = new DataStorage();

    /**
     * Getter to this class
     *
     * @return instance of this class
     */
    public static DataStorage getInstance() {
        return INSTANCE;
    }

    /**
     * Download data from file to memory
     */
    private DataStorage() {
        try (BufferedReader br = new BufferedReader(new FileReader(DATA_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                FIBONACCI_LIST.add(new Fibonacci(line));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Getter
     *
     * @param item take row's num
     * @return record
     */
    public Fibonacci getFibonacci(int item) {
        return FIBONACCI_LIST.get(item);
    }

    /**
     * Rite new num to file
     * if new num is Fibonacci it will be written in reverse
     *
     * @param fibonacci takes Fibonacci
     */
    public void setFibonacci(Fibonacci fibonacci) {
        Fibonacci checkedFibonacci;
        if (Utils.isFibonacci(fibonacci.getNum())) {
            checkedFibonacci = new Fibonacci(Utils.reverseSequence(fibonacci.getNum()));
        } else {
            checkedFibonacci = new Fibonacci(fibonacci.getNum());
        }
        try (FileWriter fl = new FileWriter(DATA_PATH, true)) {
            fl.write(checkedFibonacci.getNum() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Getter to all data
     * @return list with all data
     */
    public List<Fibonacci> getFibonacciList() {
        return FIBONACCI_LIST;
    }
}