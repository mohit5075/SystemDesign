package states;

import enums.Coin;
import modules.Inventory;
import modules.Item;
import modules.VendingMachine;

import java.util.List;

public abstract class VendingMachineState {
    protected VendingMachine vendingMachine;
    VendingMachineState(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }
    public abstract void addMoney(Coin coin);
    public abstract void selectItem(String code);
    public abstract void despenseItem();
}
