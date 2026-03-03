import java.util.Date;
import java.util.List;

public interface SplitStrategy {
    List<Split> calculateSplits(double amount, List<User> users, User paidBy, List<Double> splitValues);
}
