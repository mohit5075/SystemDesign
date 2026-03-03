public class TenRupeeCashDispenser extends CashDispenser{
    @Override
    public void setNextDispenser(CashDispenser nextDispenser) {
        this.nextDispenser = nextDispenser;
    }

    @Override
    public void dispenseCash(int amount) {
        int numOfNotes = amount / 10;
        if (numOfNotes > 0) {
            System.out.println("Dispensing " + numOfNotes + " notes of 10");
            amount = amount % 10;
        }
        if (amount > 0) {
            System.out.println("Cannot dispense remaining amount: " + amount);
        }
    }
}
