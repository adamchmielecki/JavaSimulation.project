package simulation;

import java.util.Random;

public class Army {
    public Army(int amountOfSoldiers, int amountOfTanks, int amountOfJets) {
        soldier = new Soldier();
        tank = new Tank();
        jet = new Jet();
        soldier.setCount(amountOfSoldiers);
        tank.setCount(amountOfTanks);
        jet.setCount(amountOfJets);
    }


    Soldier soldier;
    Tank tank;
    Jet jet;

    public void reduceArmy() {
       soldier.setCount(soldier.getCount()/2);
       tank.setCount(tank.getCount()/2);
       jet.setCount(jet.getCount()/2);
    }

    public void updateArmy(Country country) {
        while(country.getTotalGold() >= jet.cost && country.getTotalPopulation() >= tank.staff) {
                int a;
                Random generator = new Random();
                a = generator.nextInt(3);
                if (a == 0) {
                    soldier.createNewUnit(country);
                }
                else if (a == 1) {
                    tank.createNewUnit(country);
                }
                else if (a == 2) {
                    jet.createNewUnit(country);
                }
        }
        while (country.getTotalGold() >= soldier.cost && country.getTotalPopulation() >= soldier.staff) {
            soldier.createNewUnit(country);
        }
    }
}