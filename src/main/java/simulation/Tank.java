package simulation;

import java.util.Random;

/**
 * class responsible for storing information about parameters and method of tank
 */
public class Tank extends Unit {

    /**
     * Constructor to create an Object of an instance
     * Constructor defines parameters for tank unit
     * @param numberOfUnits number of tanks
     */
    public Tank(int numberOfUnits){
        super(numberOfUnits);
        strenghtOfAttack = 10;
        strenghtOfDefence = 20;
        staff = 15;
        cost = 25;
    }


    /*public void superTankSkill(Country offensiveCountry, Country defensiveCountry, Field field){
        bonus=bonusGenerator.nextInt(100);
        if(offensiveCountry.army.units.get(1).getCount()>=defensiveCountry.army.units.get(1).getCount()){
            if(bonus>=85){
                field.gold.setAmount(field.gold.getAmount()*2);
            }
        }
    }*/
}

