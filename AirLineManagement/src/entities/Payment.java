package entities;

import strategy.PaymentStrategy;

import java.util.UUID;

public class Payment {
    private String paymentId;
    private double amount;

    public Payment(double amount) {
        this.paymentId = UUID.randomUUID().toString();
        this.amount = amount;
    }

}
