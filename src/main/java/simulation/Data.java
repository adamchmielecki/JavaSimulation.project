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
     * This method reads the simulation parameters from the file
     * @param input file from which parameters are loaded
     * @throws IOException Constructs an IOException with null as its error detail message
     */
    public static void readInputData(BufferedReader input) throws IOException {
        numberOfCountries = lineReader(input, numberOfCountries);
        mapSize = lineReader(input, mapSize);
        numberOfIterations = lineReader(input, numberOfIterations);
    }

    /**
     * This method saves data from a file to the text field
     * @param input file from which parameters are loaded
     * @param value data read from the file
     * @return returns data parsed to int
     * @throws IOException Constructs an IOException with null as its error detail message
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
     * This method prints the country statistics after simulation
     * @param output file where the data will get saved
     * @param map map for which the simulation is performed
     * @throws IOException Constructs an IOException with null as its error detail message
     */
    public static void printSimulationResults(PrintWriter output, Map map) throws IOException {
        output.println("Countries after simulation:");
        for (int i=0; i<map.countries.size(); i++){
            if(map.countries.get(i).getTerritory().size()==0){
                output.println("ID: " + map.countries.get(i).getCountryID() + ". Doesn't exist.");
            }
            else{
                output.println("ID: " + map.countries.get(i).getCountryID() +". Fields - " + (map.countSize(map.countries.get(i)))  + "; Power of attack - " + map.countries.get(i).attack() + "; Power of defence - " + map.countries.get(i).defend());
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
