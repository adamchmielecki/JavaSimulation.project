package simulation;
import java.util.Stack;

/**
 * class responsible for operations on country
 */
public class Country {

    private int countryID;
    private int totalGold;
    private int totalPopulation;
    private Stack<Field> territory;
    Army army;

    public Country(int countryID){//, Army army) {
        army=new Army();
        territory = new Stack<>();
        this.countryID = countryID;
        //this.army = army;
        totalGold=0;
        totalPopulation=0;
    }

    /**
     * This method summing gold from all fields belong to country
     * @return returns sum of gold from all fields belong to country
     */
    public int summingCountryGold(){
        totalGold=0;
        for(int i=0; i<territory.size(); i++){
            totalGold+=territory.get(i).gold.getAmount();
        }
        return totalGold;
    }

    /**
     * This method summing population from all fields belong to country
     * @return returns sum of population from all fields belong to country
     */
    public int  summingCountryPopuation(){
        totalPopulation=0;
        for(int i=0; i<territory.size(); i++){
            totalPopulation+=territory.get(i).population.getAmount();
        }
        return totalPopulation;
    }



    int attack() {
        int powerOfAttack=0;
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
     *
     * @return return the country id
     */
    public int getCountryID() { return countryID; }

    /**
     *
     * @return return a territory of country
     */
    public Stack<Field> getTerritory() { return territory; }

    /**
     *
     * @return return total population of country
     */
    public int getTotalPopulation() { return totalPopulation; }

    /**
     *
     * @param totalPopulation allows set the number of population in the country
     */
    public void setTotalPopulation(int totalPopulation) { this.totalPopulation = totalPopulation; }

    /**
     *
     * @return total gold of country
     */
    public int getTotalGold() { return totalGold; }

    /**
     *
     * @param totalGold allows set the number of population in the country
     */
    public void setTotalGold(int totalGold) { this.totalGold = totalGold; }

}