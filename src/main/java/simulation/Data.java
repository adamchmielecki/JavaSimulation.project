package simulation;

import java.io.*;
import java.util.ArrayList;
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

    public static void printSimulationResults(PrintWriter output, ArrayList<Country> countries) throws IOException {
        output.println("Countries after simulation:");
        for (int i=0; i<countries.size(); i++){
            if(countries.get(i).getTerritory().size()==0){
                output.println("ID: " + countries.get(i).getCountryID() + ". Doesn't exist.");
            }
            else{
                output.println("ID: " + countries.get(i).getCountryID() +". Fields - " + (countries.get(i).getTerritory().size()) + "; Power of attack - " + countries.get(i).attack() + "; Power of defence - " + countries.get(i).defend());
            }
        }
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
