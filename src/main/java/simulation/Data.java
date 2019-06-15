package simulation;

import java.io.*;
import java.util.StringTokenizer;

/**
 * class responsible for loading data from the user
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


    public static void readInputData(BufferedReader input) throws IOException {
        numberOfCountries = lineReader(input, numberOfCountries);
        mapSize = lineReader(input, mapSize);
        numberOfIterations = lineReader(input, numberOfIterations);
    }

    private static int lineReader(BufferedReader input, int value) throws IOException {
        String line = input.readLine();
        StringTokenizer token = new StringTokenizer(line, ":");
        token.nextToken();
        String text = token.nextToken();
        text = text.trim();
        value = Integer.parseInt(text);
        return value;
    }


    public static int getNumberOfCountries() {
        return numberOfCountries;
    }

    public static int getMapSize() {
        return mapSize;
    }
    public static int getNumberOfIterations() {
        return numberOfIterations;
    }
}
