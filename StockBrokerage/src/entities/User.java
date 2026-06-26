package entities;

import java.util.UUID;

public class User {
    private String id;
    private String name;
    private String email;
    private Portfolio portfolio;
    private Account account;

    public User(String name, String email, Portfolio portfolio, Account account) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.portfolio = portfolio;
        this.account = account;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
