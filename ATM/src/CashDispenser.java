public abstract class CashDispenser {
    protected CashDispenser nextDispenser;
    public abstract void setNextDispenser(CashDispenser nextDispenser);
    public abstract void dispenseCash(int amount);
}
