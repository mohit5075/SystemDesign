package states;

import enums.Coin;
import modules.Inventory;
import modules.Item;
import modules.VendingMachine;

public class DispenseState extends VendingMachineState{
    public DispenseState(VendingMachine vendingMachine){
        super(vendingMachine);
    }
    @Override
    public void addMoney(Coin coin) {

    }

    @Override
    public void selectItem(String code) {

    }

    @Override
    public void despenseItem() {

    }
}
