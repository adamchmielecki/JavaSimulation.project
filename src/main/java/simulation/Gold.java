package simulation;

/**
 * This class is responsible for storing information about the amount of gold and set this value
 */
public  class Gold implements IResources {

    private  int amount;

    public Gold(int amount) {
        this.amount = amount;
    }

    /**
     * Allows us to access the variable of the gold amount
     * @return returns the amount of gold
     */
    @Override
    public int getAmount() {
        return amount;
    }

    /**
     * Allows set the value of gold amount
     * @param amount gold amount
     */
    @Override
    public void setAmount(int amount) { this.amount=amount; }
}
