public class TwoThousandCashDispenser extends CashDispenser {
    @Override
    public void setNextDispenser(CashDispenser nextDispenser) {
        this.nextDispenser = nextDispenser;
    }

    @Override
    public void dispenseCash(int amount) {
        int numOfNotes = amount / 2000;
        if (numOfNotes > 0) {
            System.out.println("Dispensing " + numOfNotes + " notes of 2000");
            amount = amount % 2000;
    }
        if (amount > 0 && nextDispenser != null) {
            nextDispenser.dispenseCash(amount);
        } else if (amount > 0) {
            System.out.println("Cannot dispense the remaining amount: " + amount);
        }
    }
}
