public class UpiPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(int amount) {
        // Simulate UPI payment processing
        System.out.println("Processing UPI payment of amount: " + amount);
    }
}
