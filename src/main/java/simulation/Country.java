package simulation;

import java.util.Random;
import java.util.Stack;

public class Country {

    private int countryID;
    Map map;

    public int getTotalPopulation() {
        return totalPopulation;
    }

    public void setTotalPopulation(int totalPopulation) {
        this.totalPopulation = totalPopulation;
    }

    public int getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(int totalGold) {
        this.totalGold = totalGold;
    }

    private int totalGold;
    private int totalPopulation;


    private Stack<Field> territory;
    public Army army;

    public Country(int countryID, Army army) {
        army=new Army(10,10,10);
        territory = new Stack<>();
        this.countryID = countryID;
        this.army = army;


        totalGold=0;
        totalPopulation=0;


    }

    public int summingCountryGold(){
        totalGold=0;
        for(int i=0; i<territory.size(); i++){
            totalGold+=territory.get(i).gold.getAmount();
        }
        return totalGold;
    }

    public int  summingCountryPopuation(){
        totalPopulation=0;
        for(int i=0; i<territory.size(); i++){
            totalPopulation+=territory.get(i).gold.getAmount();
        }
        return totalPopulation;
    }



    int attack() {
        int powerOfAttack;
        powerOfAttack = army.soldier.getCount()*army.soldier.strenghtOfAttack+army.tank.getCount()*army.tank.strenghtOfAttack+army.jet.getCount()*army.jet.strenghtOfAttack;
        return powerOfAttack;
    }

    int defend() {
        int powerOfDefence;
        powerOfDefence = army.soldier.getCount()*army.soldier.strenghtOfDefence+army.tank.getCount()*army.tank.strenghtOfDefence+army.jet.getCount()*army.jet.strenghtOfDefence;
        return powerOfDefence;
    }

    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }


    public Stack<Field> getTerritory() {
        return territory;
    }

    public void setTerritory(Stack<Field> territory) {
        this.territory = territory;
    }
}