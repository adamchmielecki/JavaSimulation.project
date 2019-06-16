package simulation;

import java.util.Random;

/**
 * This class is responsible for storing information about parameters and method of soldier
 */
public class Soldier extends Unit {

    /**
     * Constructor to create an Object of an instance
     * Constructor defines parameters for soldier unit
     * @param numberOfUnits number of soldiers
     */
    public Soldier(int numberOfUnits){
        super(numberOfUnits);
        strenghtOfAttack = 5;
        strenghtOfDefence = 5;
        staff = 10;
        cost = 10;
    }

    /* public void createNewSoldier(Country country){
         setCount(getCount() + 1);
         country.setTotalGold(country.getTotalGold() - cost);
         country.setTotalPopulation(country.getTotalPopulation() - staff);
     }*/
    /*public void superSoldierSkill(Country offensiveCountry, Country defensiveCountry, Field field){
        bonus=bonusGenerator.nextInt(100);
        if(offensiveCountry.army.soldiers.size()>=defensiveCountry.army.soldiers.size()){
            if(bonus>=85){
                field.population.setAmount(field.population.getAmount()*2);
            }
        }
    }*/


}
