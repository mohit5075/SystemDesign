package Service;

import entities.Payment;
import strategy.PaymentStrategy;

public class PaymentService {

    public PaymentService() {
    }
    public Payment makePayment(double amount,PaymentStrategy paymentStrategy){
        Payment payment = new Payment(amount);
        paymentStrategy.pay(amount);
        return payment;
    }
}
