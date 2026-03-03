package states;

import enums.Coin;
import modules.Inventory;
import modules.Item;
import modules.VendingMachine;

import java.util.List;

public class IdleState extends VendingMachineState{
    public IdleState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void addMoney(Coin coin) {
        System.out.println("Select modules.Item first before adding money");
    }

    @Override
    public void selectItem(String code) {
        if(!vendingMachine.getInventory().getItemMap().containsKey(code)){
            System.out.println("Item not available.");
            return;
        }
        vendingMachine.selectItem(code);
        System.out.println("Item Selected");
        vendingMachine.setVendingMachineState(new ItemSelectedState(vendingMachine));
    }

    @Override
    public void despenseItem() {
        System.out.println("Select item first and add money");
    }
}
