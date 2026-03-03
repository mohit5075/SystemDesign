package strategy;

public class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public void pay(double amount) {
        System.out.println("Payment needs to be done through upi");
    }
}
