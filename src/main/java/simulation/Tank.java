package simulation;

import java.util.Random;

/**
 * class responsible for storing information about parameters and method of tank
 */
public class Tank extends Unit {

    /**
     * Constructor to create an Object of an instance
     * Constructor defines parameters for tank unit
     *
     * @param numberOfUnits number of tanks
     */
    public Tank(int numberOfUnits) {
        super(numberOfUnits);
        strenghtOfAttack = 10;
        strenghtOfDefence = 20;
        staff = 15;
        cost = 25;
        levelOfUpgrade=1;
    }

    /**
     * This method increases the tank's strength of defence
     */
    @Override
    public void upgradeUnits() {
        if(this.getCount()>=levelOfUpgrade*700 && strenghtOfDefence<30){
            this.strenghtOfDefence=this.strenghtOfDefence+1;
            levelOfUpgrade++;
        }
    }
}

