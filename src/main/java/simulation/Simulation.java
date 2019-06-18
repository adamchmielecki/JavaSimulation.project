package simulation;

import java.io.*;

/**
 * This class is responsible for loading data from the file and run the simulation
 */
public class Simulation {


    /**
     * This method is responsible for loading data from the file
     */
    public void loadData() {
        try {
            BufferedReader input = new BufferedReader(new FileReader("InputData.txt"));
            Data.readInputData(input);
            input.close();
        } catch (
                IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * This method is responsible for start simulation
     */
    public void startSimulation() {
        Data data = new Data(Data.getNumberOfCountries(), Data.getMapSize(), Data.getNumberOfIterations());

        if(Data.getNumberOfCountries()>Data.getMapSize()*Data.getMapSize()||Data.getNumberOfIterations()<1||Data.getMapSize()<1) {
            try {
                PrintWriter output = new PrintWriter(new FileWriter("SimulationResults.txt"));
                output.println("Wrong starting simulation parameters!");
                output.println("Enter new values in the 'InputData.txt' file.");
                output.close();
            } catch (
                    IOException e) {
                System.out.println(e.getMessage());
            }
        }
        else {
            Map map = new Map(data);
            map.settingID();
            map.generateResources(100, 10);
            map.generateStartingPosition();
            for (int i = 0; i < data.getNumberOfCountries(); i++) {
                map.countries.get(i).army.generateArmy();
            }


            for (int i = 0; i < data.getNumberOfIterations(); i++) {
                map.generateResources(100, 50);

                for (int j = 0; j < data.getNumberOfCountries(); j++) {
                    map.takeNewField(j);
                    map.countries.get(j).summingCountryPopuation(data, map);
                    map.countries.get(j).summingCountryGold(data, map);
                    map.countries.get(j).army.updateArmy(map.countries.get(j));
                }
            }

            try {
                PrintWriter output = new PrintWriter(new FileWriter("SimulationResults.txt"));
                Data.printSimulationResults(output, map);
                output.close();
            } catch (
                    IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }

}