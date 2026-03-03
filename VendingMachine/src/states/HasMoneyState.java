package states;

import enums.Coin;
import modules.Inventory;
import modules.Item;
import modules.VendingMachine;

public class HasMoneyState extends VendingMachineState{
    public HasMoneyState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void addMoney(Coin coin) {
        System.out.println("Money already added.");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void despenseItem() {
        vendingMachine.dispenseItem();
        vendingMachine.setVendingMachineState(new DispenseState(vendingMachine));
    }
}
