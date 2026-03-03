public class OneHundredCashDispenser extends CashDispenser{
    @Override
    public void setNextDispenser(CashDispenser nextDispenser) {
        this.nextDispenser = nextDispenser;
    }

    @Override
    public void dispenseCash(int amount) {
        int numOfNotes = amount / 100;
        if (numOfNotes > 0) {
            System.out.println("Dispensing " + numOfNotes + " notes of 100");
            amount = amount % 100;
        }
        if (amount > 0 && nextDispenser != null) {
            nextDispenser.dispenseCash(amount);
        } else if (amount > 0) {
            System.out.println("Cannot dispense remaining amount: " + amount);
        }
    }
}
