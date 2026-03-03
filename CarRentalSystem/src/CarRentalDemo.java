import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarRentalDemo {
    public static void main(String[] args) {
        Car car1 = new Car(1,"Maruti","Swift",500,true,101,"MH12AB1234");
        Car car2 = new Car(2,"Hyundai","i20",700,true,102,"MH14CD5678");
        Car car3 = new Car(3,"Honda","Civic",1000,true,103,"MH16EF9012");
        Map<String,Car> carMap=new ConcurrentHashMap<>();
        Map<String,Reservation> reservationMap=new ConcurrentHashMap<>();
        PaymentProcessor paymentProcessor=new UpiPaymentProcessor();
        CarRental carRental=new CarRental(carMap,reservationMap,paymentProcessor);
        carRental.addCar(car1);
        carRental.addCar(car2);
        carRental.addCar(car3);
        Customer customer=new Customer(1,"John Doe","john@example.com");
        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(3);
        List<Car> availableCars=carRental.searchCar("Maruti","Swift",startDate,endDate);
        if(!availableCars.isEmpty()){
            Car car = availableCars.get(0);
            Reservation reservation=carRental.makeReservation(car,startDate,endDate,customer);
            car.setAvailable(false);
            System.out.println("Reservation made for car: " + reservation.getCar().getModel());
            int days = (int) (endDate.toEpochDay() - startDate.toEpochDay());
            boolean paymentResult = carRental.makePayment(reservation.getCar().getPricePerDay() * days);
            if(paymentResult){
                System.out.println("Payment successful for amount: " + (reservation.getCar().getPricePerDay() * days));
            } else {
                System.out.println("Payment failed. Cancelling reservation.");
                carRental.cancelReservation(reservation.getCar().getLicensePlate());
            }
            carRental.cancelReservation(reservation.getCar().getLicensePlate());
            System.out.println("Reservation cancelled for car: " + reservation.getCar().getModel());
        }
    }
}
