package strategy;

public class CreditCardPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("payment needs to be done through credit card");
    }
}
