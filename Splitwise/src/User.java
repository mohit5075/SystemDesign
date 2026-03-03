public class User {
    private String name;
    private String email;
    private BalanceSheet balanceSheet;
    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.balanceSheet = new BalanceSheet(this);
    }
    public String getName(){
        return name;
    }
    public BalanceSheet getBalanceSheet(){
        return balanceSheet;
    }
}
