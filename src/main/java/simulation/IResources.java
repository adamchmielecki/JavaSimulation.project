package simulation;

/**
 * This interface defines methods for resources(gold and population)
 */
public interface IResources {

    int amount = 0;

    /**
     * Allows us to access the variable of the amount od resource
     * @return resource amount
     */
    int getAmount();

    /**
     * Allows set the value of resource amount
     * @param amount resource amount
     */
    void setAmount(int amount);

}
