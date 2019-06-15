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


    public void superTankSkill(Country offensiveCountry, Country defensiveCountry, Field field){
        bonus=bonusGenerator.nextInt(100);
        if(offensiveCountry.army.tanks.size()>=defensiveCountry.army.tanks.size()){
            if(bonus>=85){
                field.gold.setAmount(field.gold.getAmount()*2);
            }
        }
    }
}

