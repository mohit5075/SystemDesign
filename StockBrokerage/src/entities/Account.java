package entities;

public class Account {
    private int amount;

    public Account(int amount) {
        this.amount = amount;
    }
    private void add(int delta){
        this.amount+=delta;
    }
    private void remove(int delta){
        this.amount-=delta;
    }

    public int getAmount() {
        return amount;
    }
}
