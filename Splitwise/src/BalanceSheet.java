import java.util.HashMap;
import java.util.Map;

public class BalanceSheet {
    private User owner;
    private double netBalance;
    private Map<User, Double> balances = new HashMap<>();
    public BalanceSheet(User owner) {
        this.owner = owner;
        this.netBalance = 0.0;
    }
    public void addBalance(User user, double amount) {
        balances.merge(user,amount,Double::sum);
    }
    public void printBalanceSheet() {
        double  totalLent = 0.0;
        double totalOwed = 0.0;
        System.out.println("Balance Sheet for " + owner.getName() + ":");
        for(Map.Entry<User, Double> entry : balances.entrySet()) {
            User user = entry.getKey();
            double amount = entry.getValue();
            if(amount > 0) {
                System.out.println(user.getName() + " owes " + owner.getName() + ": $" + String.format("%.2f", amount));
                totalLent += amount;
            } else if(amount < 0) {
                System.out.println(owner.getName() + " owes " + user.getName() + ": $" + String.format("%.2f", -amount));
                totalOwed += -amount;
            }
        }
        netBalance = totalLent - totalOwed;
        System.out.println("Total Lent: $" + String.format("%.2f", totalLent));
        System.out.println("Total Owed: $" + String.format("%.2f", totalOwed));
        System.out.println("Net Balance: $" + String.format("%.2f", netBalance));
    }
}
