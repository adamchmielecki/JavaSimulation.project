package simulation;

import java.util.Random;

public class Tank extends Unit {

    public Tank(){
        super(0);
        strenghtOfAttack = 10;
        strenghtOfDefence = 20;
        staff = 15;
        cost = 25;
    }

   /* public void createNewTank(Country country){
        setCount(getCount() + 1);
        country.setTotalGold(country.getTotalGold() - cost);
        country.setTotalPopulation(country.getTotalPopulation() - staff);
    }*/
    public void superTankSkill(Country country1, Country country2, Field field){
        bonus=bonusGenerator.nextInt(100);
        if(country1.army.tank.getCount()>=country2.army.tank.getCount()){
            if(bonus>=85){
                field.gold.setAmount(field.gold.getAmount()*2);
            }
        }
    }
}
