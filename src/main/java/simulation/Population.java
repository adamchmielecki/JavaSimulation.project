package simulation;

public class Population implements IResources {

    private  int amount;

    public Population(int amount) {
        this.amount = amount;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount=amount;
    }
}
