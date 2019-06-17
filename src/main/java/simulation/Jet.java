package simulation;

/**
 * class responsible for storing information about parameters and method of jet
 */
public class Jet extends Unit {

    /**
     * Constructor to create an Object of an instance
     * Constructor defines parameters for jet unit
     * @param numberOfUnits number of jets
     */
    public Jet(int numberOfUnits){
        super(numberOfUnits);
        strenghtOfAttack = 15;
        strenghtOfDefence = 15;
        staff = 10;
        cost = 50;
        levelOfUpgrade=1;
    }

    /**
     * This method decreases the cost of production jets
     */
    @Override
    public void upgradeUnits() {
        if(this.getCount()>=levelOfUpgrade*1000&&this.cost>30){
            this.cost=this.cost-1;
            levelOfUpgrade++;
        }
    }
}
