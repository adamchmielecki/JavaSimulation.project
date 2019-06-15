package simulation;

public  class Gold implements IResources {

    private  int amount;

    public Gold(int amount) {
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
