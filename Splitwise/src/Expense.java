import java.time.LocalDateTime;
import java.util.List;

public class Expense {
    private User paidBy;
    private double amount;
    private List<Split> splits;
    private String description;
    private LocalDateTime timestamp;
    public Expense(ExpenseBuilder expenseBuilder) {
        this.paidBy = expenseBuilder.paidBy;
        this.amount = expenseBuilder.amount;
        this.splits = expenseBuilder.splitStrategy.calculateSplits(amount, expenseBuilder.users, paidBy, expenseBuilder.splitValues);
        this.description = expenseBuilder.description;
        this.timestamp = LocalDateTime.now();
    }
    private static class ExpenseBuilder{
        private User paidBy;
        private double amount;
        private List<User> users;
        private List<Split> splits;
        private SplitStrategy splitStrategy;
        private List<Double> splitValues;
        private String description;
        public ExpenseBuilder setPaidBy(User paidBy) {
            this.paidBy = paidBy;
            return this;
        }
        public ExpenseBuilder setAmount(double amount) {
            this.amount = amount;
            return this;
        }
        public ExpenseBuilder setSplits(List<Split> splits) {
            this.splits = splits;
            return this;
        }
        public ExpenseBuilder setDescription(String description) {
            this.description = description;
            return this;
        }
        public Expense build() {
            return new Expense(this);
        }
        public ExpenseBuilder setSplitStrategy(SplitStrategy splitStrategy) {
            this.splitStrategy = splitStrategy;
            return this;
        }
        public ExpenseBuilder setSplitValues(List<Double> splitValues) {
            this.splitValues = splitValues;
            return this;
        }
        public ExpenseBuilder setUsers(List<User> users) {
            this.users = users;
            return this;
        }
    }
}
