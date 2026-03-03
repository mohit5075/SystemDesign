public class Transaction {
    private User fromUser;
    private User toUser;
    private double amount;
    public Transaction(User fromUser, User toUser, double amount) {
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.amount = amount;
    }
}
