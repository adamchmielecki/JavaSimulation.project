package simulation;

import java.util.Random;

public abstract class Unit implements IUnit {

    protected int count;
    public int strenghtOfAttack;
    public int strenghtOfDefence;
    public int staff;
    public int cost;
    int bonus;
    Random bonusGenerator;

    public Unit(int count){
        this.count = count;
    }

    public void createNewUnit(Country country){
        setCount(getCount()+1);
        country.setTotalGold(country.getTotalGold() - cost);
        country.setTotalPopulation(country.getTotalPopulation() - staff);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
