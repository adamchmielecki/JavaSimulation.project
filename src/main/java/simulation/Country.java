package simulation;
import java.util.Stack;

/**
 * This class is responsible for operations on country
 */
public class Country {

    private int countryID;
    private int totalGold;
    private int totalPopulation;
    private Stack<Field> territory;
    Army army;


    /**
     * Constructor to create an Object of an instance
     * @param countryID  unique id of country
     */
    public Country(int countryID){
        army=new Army();
        territory = new Stack<>();
        this.countryID = countryID;
        totalGold=0;
        totalPopulation=0;
    }

    /**
     * This method summing gold from all fields belong to country
     * @return returns sum of gold from all fields belong to country
     */
    public int summingCountryGold(Data data, Map map){
        totalGold=0;

        for(int j=0; j<data.getMapSize(); j++){
            for(int k=0; k<data.getMapSize(); k++){
                if(map.field[j][k].getOwnerID()==this.countryID){
                    totalGold+=map.field[j][k].gold.getAmount();
                }
            }
        }

        return totalGold;
    }

    /**
     * This method summing population from all fields belong to country
     * @return returns sum of population from all fields belong to country
     */
    public int  summingCountryPopuation(Data data, Map map){
        totalPopulation=0;

        for(int j=0; j<data.getMapSize(); j++){
            for(int k=0; k<data.getMapSize(); k++){
                if(map.field[j][k].getOwnerID()==this.countryID){
                    totalPopulation+=map.field[j][k].population.getAmount();
                }
            }
        }


        return totalPopulation;
    }


    /**
     * This method determines the strength of the country attack
     * @return strength of the country attack
     */
    int attack() {
        int powerOfAttack=0;
        new Soldier(1).upgradeUnits();
        for (Unit unit: army.units) {
            powerOfAttack+=unit.getCount()*unit.strenghtOfAttack;
        }
        return powerOfAttack;
    }
    /**
     * This method determines the strength of the country defence
     * @return strength of the country defence
     */
    int defend() {
        int powerOfDefence=0;
        for (Unit unit: army.units) {
            powerOfDefence+=unit.getCount()*unit.strenghtOfDefence;
        }
        return powerOfDefence;
    }

    /**
     * Allows us to access the variable of the country ID
     * @return return the country id
     */
    public int getCountryID() { return countryID; }

    /**
     * Allows us to access the stack of the country territory
     * @return return a territory of country
     */
    public Stack<Field> getTerritory() { return territory; }

    /**
     * Allows us to access the variable of the total number of population of the country
     * @return return total population of country
     */
    public int getTotalPopulation() { return totalPopulation; }

    /**
     * Allows set the number of total population in the country
     * @param totalPopulation total population country
     */
    public void setTotalPopulation(int totalPopulation) { this.totalPopulation = totalPopulation; }

    /**
     * Allows us to access the variable of total number of gold of the country
     * @return total gold of country
     */
    public int getTotalGold() { return totalGold; }

    /**
     * Allows set the number of total gold in the country
     * @param totalGold total gold country
     */
    public void setTotalGold(int totalGold) { this.totalGold = totalGold; }

}