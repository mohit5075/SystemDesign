package states;

import enums.Coin;
import modules.Inventory;
import modules.Item;
import modules.VendingMachine;

public class ItemSelectedState extends VendingMachineState{
    public ItemSelectedState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void addMoney(Coin coin) {
        vendingMachine.addBalance(coin.getValue());
        System.out.println("Coin Inserted: " + coin.getValue());
        int price = vendingMachine.getSelectedItem().getPrice();
        if(price<=vendingMachine.getBalance()){
            System.out.println("Sufficient money received.");
            vendingMachine.setVendingMachineState(new HasMoneyState(vendingMachine));
        }
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void despenseItem() {
        System.out.println("Please insert sufficient money.");
    }
}
