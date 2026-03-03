import java.util.ArrayList;
import java.util.List;

public class EqualSplitStrategy implements SplitStrategy{
    @Override
    public List<Split> calculateSplits(double amount, List<User> users, User paidBy, List<Double> splitValues) {
        double amountPerUser = amount / users.size();
        List<Split> splits=new ArrayList<>();
        for (User user : users) {
            splits.add(new Split(user, amountPerUser));
        }
        return splits;
    }
}
