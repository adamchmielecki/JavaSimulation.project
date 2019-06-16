package simulation;

import java.io.*;

/**
 * This class is responsible for loading data from the file and run the simulation
 */
public class Simulation {


    /**
     * This method is responsible for loading data from the file
     */
    public void loadData(){
        try{
            BufferedReader input = new BufferedReader(new FileReader("InputData.txt"));
            Data.readInputData(input);
            input.close();
        }
        catch (
                IOException e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * This method is responsible for start simulation
     */
    public void startSimulation(){
        Data data = new Data(Data.getNumberOfCountries(), Data.getMapSize(), Data.getNumberOfIterations());

        System.out.println(Data.getNumberOfCountries());
        System.out.println(Data.getMapSize());
        System.out.println(Data.getNumberOfIterations());

        Map map = new Map(data);
        map.settingID();
        map.generateResources(100,10);
        map.generateStartingPosition();
        map.printMap();
        for(int i=0; i<data.getNumberOfCountries(); i++){
            map.countries.get(i).army.generateArmy();
        }

        /*System.out.println(map.countries.get(0).army.units.get(0).getCount());
        System.out.println(map.countries.get(0).army.units.get(1).getCount());
        System.out.println(map.countries.get(0).army.units.get(2).getCount());
        System.out.println();
        System.out.println(map.countries.get(1).army.units.get(0).getCount());
        System.out.println(map.countries.get(1).army.units.get(1).getCount());
        System.out.println(map.countries.get(1).army.units.get(2).getCount());*/


        for(int i=0; i<data.getNumberOfIterations(); i++){
            map.generateResources(100,100);
            map.takeNewField();
            for(int j=0; j<data.getNumberOfCountries(); j++){
                map.countries.get(j).summingCountryPopuation();
                map.countries.get(j).summingCountryGold();
                map.countries.get(j).army.updateArmy(map.countries.get(j));
            }
            System.out.println("Iteracja: "+i);
        }
        /*System.out.println();
        System.out.println(map.countries.get(0).army.units.get(0).getCount());
        System.out.println(map.countries.get(0).army.units.get(1).getCount());
        System.out.println(map.countries.get(0).army.units.get(2).getCount());
        System.out.println();
        System.out.println(map.countries.get(1).army.units.get(0).getCount());
        System.out.println(map.countries.get(1).army.units.get(1).getCount());
        System.out.println(map.countries.get(1).army.units.get(2).getCount());
        System.out.println();
        System.out.println(map.countries.get(1).army.units.size());
        System.out.println(map.countries.get(0).getTotalGold());
        System.out.println(map.countries.get(0).getTotalPopulation());*/
        System.out.println();
        System.out.println("Map after the simulation:");
        map.printMap();

        try{
            PrintWriter output = new PrintWriter(new FileWriter("SimulationResults.txt"));
            Data.printSimulationResults(output, map.countries);
            output.close();
        }
        catch (
                IOException e){
            System.out.println(e.getMessage());
        }
    }


}

