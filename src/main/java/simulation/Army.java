package simulation;

import java.util.ArrayList;
import java.util.Random;

public class Army  {
    public Army() {
        generator = new Random();
        soldiers = new ArrayList<>();
        tanks = new ArrayList<>();
        jets = new ArrayList<>();
    }

    Random generator;
    ArrayList<Soldier> soldiers;
    ArrayList<Tank> tanks;
    ArrayList<Jet> jets;

    public void superMethods(Country offensiveCountry, Country defensiveCountry, Field field){
        new Soldier().superSoldierSkill(offensiveCountry,defensiveCountry,field);
        new Tank().superTankSkill(offensiveCountry,defensiveCountry,field);
        new Jet().superJetSkill(offensiveCountry,defensiveCountry,field);
    }

    public void generateArmy(){
        int numberOfUnits;
        numberOfUnits=generator.nextInt(100);
        for(int i = 0; i<numberOfUnits; i++){
            soldiers.add(new Soldier());
        }
        numberOfUnits=generator.nextInt(50);
        for(int i = 0; i<numberOfUnits; i++){
            tanks.add(new Tank());
        }
        numberOfUnits=generator.nextInt(25);
        for(int i = 0; i<numberOfUnits; i++){
            jets.add(new Jet());
        }

    }

    public void reduceArmy() {
        for(int i=soldiers.size()/2; i<soldiers.size(); i++) {
            soldiers.remove(i);
        }
        for(int i=tanks.size()/2; i<tanks.size(); i++) {
            tanks.remove(i);
        }
        for(int i=jets.size()/2; i<jets.size(); i++) {
            jets.remove(i);
        }

    }

    public void updateArmy(Country country) {
        while(country.getTotalGold() >= new Jet().cost && country.getTotalPopulation() >= new Tank().staff) {
            int a;
            a = generator.nextInt(3);
            if (a == 0) {
                soldiers.add(new Soldier());
                new Soldier().createNewUnit(country);
            }
            else if (a == 1) {
                tanks.add(new Tank());
                new Tank().createNewUnit(country);
            }
            else if (a == 2) {
                jets.add(new Jet());
                new Jet().createNewUnit(country);
            }
        }
        while (country.getTotalGold() >= new Soldier().cost && country.getTotalPopulation() >= new Soldier().staff) {
            new Soldier().createNewUnit(country);
        }
    }


}