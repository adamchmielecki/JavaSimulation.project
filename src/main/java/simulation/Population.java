package simulation;

/**
 * This class is responsible for storing information about the amount of gold and set this value
 */
public class Population implements IResources {

    private  int amount;

    public Population(int amount) {
        this.amount = amount;
    }

    /**
     * Allows us to access the variable of the population amount
     * @return returns the amount of population
     */
    @Override
    public int getAmount() {
        return amount;
    }

    /**
     * Allows set the value of population amount
     * @param amount population amount
     */
    @Override
    public void setAmount(int amount) {
        this.amount=amount;
    }
}
