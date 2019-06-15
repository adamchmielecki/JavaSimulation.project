package simulation;

import java.util.ArrayList;
import java.util.Random;

/**
 *class responsible for operations on the army of each country
 */
public class Army  {

    public Army() {
        generator = new Random();
        units = new ArrayList<>();
    }

    Random generator;
    ArrayList<Unit> units;

/*    public void superMethods(Country offensiveCountry, Country defensiveCountry, Field field){
    /**
     * collection of special methods that can be called after the battle
     * @param offensiveCountry the country that is carrying out the attack
     * @param defensiveCountry the country which is attacked
     * @param field place of the battle
     */
    /*public void superMethods(Country offensiveCountry, Country defensiveCountry, Field field){
        new Soldier().superSoldierSkill(offensiveCountry,defensiveCountry,field);
        new Tank().superTankSkill(offensiveCountry,defensiveCountry,field);
        new Jet().superJetSkill(offensiveCountry,defensiveCountry,field);
    }*/

    /**
     * This method generates armies for each country at the beginning of the simulation
     */
    public void generateArmy(){
        int numberOfUnits;

        numberOfUnits=generator.nextInt(100);
        units.add(new Soldier(numberOfUnits));

        numberOfUnits=generator.nextInt(50);
        units.add(new Tank(numberOfUnits));

        numberOfUnits=generator.nextInt(25);
        units.add(new Jet(numberOfUnits));
    }

    /**
     * This method reduces armies after losing battle
     */
    public void reduceArmy() {
        for (Unit unit: units) unit.setCount(unit.getCount()/2);
    }

    public int mostExpensiveUnit=0;
    public int mostValuableUnit=0;

    /**
     * This method creates new units for each country in each iteration
     * @param country the country where the operation is performed
     */
    public void updateArmy(Country country) {
        for (Unit unit:units) {
            if(unit.cost>mostExpensiveUnit) mostExpensiveUnit = unit.cost;
            if(unit.staff>mostValuableUnit) mostValuableUnit = unit.staff;
        }
        while(country.getTotalGold() >= mostExpensiveUnit && country.getTotalPopulation() >= mostValuableUnit) {
            int x;
            x = generator.nextInt(units.size());
            units.get(x).createNewUnit(country);
        }
        while (country.getTotalGold() >= units.get(0).cost && country.getTotalPopulation() >= units.get(0).staff) {
            units.get(0).createNewUnit(country);
        }
    }

}