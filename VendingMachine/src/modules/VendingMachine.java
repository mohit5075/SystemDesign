package modules;

import enums.Coin;
import states.IdleState;
import states.VendingMachineState;

public class VendingMachine {
    private final static VendingMachine instance = new VendingMachine();
    private VendingMachineState vendingMachineState;
    private final Inventory inventory = new Inventory();
    private String selectedItem;
    private int balance = 0;
    public VendingMachine(){
        this.vendingMachineState = new IdleState(this);
    }
    public static VendingMachine getInstance(){
        return instance;
    }
    public void addMoney(Coin coin){
        vendingMachineState.addMoney(coin);
    }
    public void selectItem(String code){
        vendingMachineState.selectItem(code);
    }
    public void addIem(String name, int quantity, int price){
        Item item  = new Item(name,price);
        inventory.addItem(item,quantity);
    }

    public int getBalance() {
        return balance;
    }

    public void addBalance(int balance) {
        this.balance += balance;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public Item getSelectedItem() {
        return inventory.getItem(selectedItem);
    }

    public void dispenseItem(){
        Item item = inventory.getItem(selectedItem);
        int price = item.getPrice();
        if(price<=balance){
            balance-=price;
            inventory.removeItem(selectedItem);
            if(balance>0){
                System.out.println("Change : "+balance);
            }
        }
        reset();
    }
    public void reset(){
        this.balance=0;
        selectedItem=null;
        vendingMachineState = new IdleState(this);
    }

}
