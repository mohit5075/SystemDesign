import java.util.ArrayList;
import java.util.List;

public class PercentageSplitStrategy implements SplitStrategy {
    @Override
    public List<Split> calculateSplits(double amount, List<User> users, User paidBy, List<Double> splitValues) {
        if(users.size() != splitValues.size()) {
            throw new IllegalArgumentException("Number of users and split values must be the same.");
        }
        List<Split> splits = new ArrayList<>();
        for(int i=0;i<users.size();i++){
            double amountForUser = (splitValues.get(i) / 100) * amount;
            splits.add(new Split(users.get(i), amountForUser));
        }
        return splits;
    }
}
