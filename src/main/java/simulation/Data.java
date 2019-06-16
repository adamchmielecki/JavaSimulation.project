package simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * This class is responsible for loading data from the user
 */
public class Data {
    private static int numberOfCountries;
    private static int mapSize;
    private static int numberOfIterations;

    public Data(int numberOfCountries, int mapSize, int numberOfIterations) {
        this.numberOfCountries = numberOfCountries;
        this.mapSize = mapSize;
        this.numberOfIterations = numberOfIterations;
    }


    /**
     *
     * @param input
     * @throws IOException
     */
    public static void readInputData(BufferedReader input) throws IOException {
        numberOfCountries = lineReader(input, numberOfCountries);
        mapSize = lineReader(input, mapSize);
        numberOfIterations = lineReader(input, numberOfIterations);
    }

    /**
     *
     * @param input
     * @param value
     * @return
     * @throws IOException
     */
    private static int lineReader(BufferedReader input, int value) throws IOException {
        String line = input.readLine();
        StringTokenizer token = new StringTokenizer(line, ":");
        token.nextToken();
        String text = token.nextToken();
        text = text.trim();
        value = Integer.parseInt(text);
        return value;
    }

    /**
     * Allows to access the variable of number of countries
     * @return returns number of countries take part in simulation
     */
    public static int getNumberOfCountries() {
        return numberOfCountries;
    }

    /**
     * Allows to access the variable of size of map
     * @return returns the size of the map
     */
    public static int getMapSize() {
        return mapSize;
    }

    /**
     * Allows to access the variable of number of iterations
     * @return returns number of round in simulation
     */
    public static int getNumberOfIterations() {
        return numberOfIterations;
    }
}
