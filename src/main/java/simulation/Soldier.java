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
        levelOfUpgrade=1;
    }

    /**
     * This method increases the soldier's strength of attack
     */
    @Override
    public void upgradeUnits() {
        if(this.getCount()>=levelOfUpgrade*1000 && strenghtOfAttack<10){
            this.strenghtOfAttack=this.strenghtOfAttack+1;
            levelOfUpgrade++;
        }
    }

}
