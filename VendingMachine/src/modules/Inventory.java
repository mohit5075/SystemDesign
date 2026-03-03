package modules;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Item> itemMap;
    private Map<String,Integer> stockMap;
    public Inventory(){
        this.itemMap = new HashMap<>();
        this.stockMap = new HashMap<>();
    }
    public void addItem(Item item, int quantity){
        itemMap.put(item.getId(),item);
        stockMap.merge(item.getId(),quantity, Integer::sum);
    }

    public Map<String, Item> getItemMap() {
        return itemMap;
    }

    public Map<String, Integer> getStockMap() {
        return stockMap;
    }
    public Item getItem(String code){
        return itemMap.get(code);
    }
    public void removeItem(String code){
        stockMap.merge(code,-1,Integer::sum);
    }
}
