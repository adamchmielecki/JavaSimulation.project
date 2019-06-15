package simulation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Simulation {


    public void startSimulation(){
        try{
            BufferedReader input = new BufferedReader(new FileReader("InputData.txt"));
            Data.readInputData(input);
            input.close();
        }
        catch (
                IOException e){
            System.out.println(e.getMessage());
        }



        Data data = new Data(Data.getNumberOfCountries(), Data.getMapSize(), Data.getNumberOfIterations());

        Map map = new Map(data);
        map.settingID();
        map.generateResources(100,10);
        map.generateStartingPosition();
        map.printMap();
        for(int i=0; i<data.getNumberOfCountries(); i++){
            map.countries.get(0).army.generateArmy();
        }



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
        System.out.println();
        System.out.println("Map after the simulation:");
        map.printMap();
    }


}

