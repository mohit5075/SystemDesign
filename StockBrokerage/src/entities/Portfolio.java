package entities;

import java.util.HashMap;
import java.util.Map;

public class Portfolio {
    private Map<String,Integer> stocks;

    public Portfolio() {
        this.stocks = new HashMap<>();
    }
    public void addStock(String symbol, int delta){
        if(stocks.containsKey(symbol))
        stocks.merge(symbol,delta,Integer::sum);
        else stocks.put(symbol,delta);
    }
    public void removeStocks(String symbol, int delta){
        stocks.merge(symbol,-delta,Integer::sum);
    }
    public int getStockQuantity(String symbol){
        return stocks.get(symbol);
    }
}
