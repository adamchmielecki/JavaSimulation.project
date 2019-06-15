package simulation;

import java.util.Random;

public class Soldier extends Unit {

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
