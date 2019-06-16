package simulation;



/**
 * Abstract class defines basic attributes for every military class
 */
public abstract class Unit implements IUnit {

    protected int count;
    public int strenghtOfAttack;
    public int strenghtOfDefence;
    public int staff;
    public int cost;
    /*int bonus;
    Random bonusGenerator;*/

    public Unit(int count){
        this.count = count;
    }

    /**
     * This method creates new units
     * @param country the country for which the units are created
     */
    public void createNewUnit(Country country){
        setCount(getCount()+1);
        country.setTotalGold(country.getTotalGold() - cost);
        country.setTotalPopulation(country.getTotalPopulation() - staff);
    }

    /**
     * Allows access to a variable that holds the number of units of each type
     * @return returns number of units
     */
    public int getCount() {
        return count;
    }

    /**
     * Allows set the number of units
     * @param count number of units
     */
    public void setCount(int count) {
        this.count = count;
    }

}
