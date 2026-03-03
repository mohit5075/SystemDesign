public class ATM {
    public CashDispenser dispenserChain;
    public ATM(){
        TwoThousandCashDispenser twoThousandDispenser = new TwoThousandCashDispenser();
        FiveHundredCashDispenser fiveHundredDispenser = new FiveHundredCashDispenser();
        OneHundredCashDispenser oneHundredDispenser = new OneHundredCashDispenser();
        TenRupeeCashDispenser tenRupeeDispenser = new TenRupeeCashDispenser();
        oneHundredDispenser.setNextDispenser(tenRupeeDispenser);
        fiveHundredDispenser.setNextDispenser(oneHundredDispenser);
        twoThousandDispenser.setNextDispenser(fiveHundredDispenser);
        this.dispenserChain = twoThousandDispenser;
    }

    public void dispenseAmount(int amount){
        dispenserChain.dispenseCash(amount);
    }
}
