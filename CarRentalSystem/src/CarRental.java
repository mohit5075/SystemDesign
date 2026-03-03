import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CarRental {
    private Map<String,Car> cars;
    private Map<String, Reservation> reservations;
    private PaymentProcessor paymentProcessor;
    public CarRental(Map<String, Car> cars, Map<String, Reservation> reservations, PaymentProcessor paymentProcessor) {
        this.cars = cars;
        this.reservations = reservations;
        this.paymentProcessor = paymentProcessor;
    }
    public void addCar(Car car) {
        cars.put(car.getLicensePlate(), car);
    }
    public void removeCar(String licensePlate) {
        cars.remove(licensePlate);
    }
    public Reservation makeReservation(Car car, LocalDate startDate, LocalDate endDate, Customer customer) {
        if(car.isAvailable()){
            Reservation reservation = new Reservation(car, startDate, endDate, customer);
            reservations.put(car.getLicensePlate(), reservation);
            car.setAvailable(false);
            return reservation;
        } else {
            throw new IllegalStateException("Car is not available for reservation");
        }
    }
    public void cancelReservation(String licensePlate) {
        Reservation reservation = reservations.get(licensePlate);
        if(reservation != null){
            reservation.getCar().setAvailable(true);
            reservations.remove(licensePlate);
        } else {
            throw new IllegalStateException("No reservation found for the given car");
        }
    }
    public boolean makePayment(int amount) {
        try {
            paymentProcessor.processPayment(amount);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<Car> searchCar(String brand, String model, LocalDate startDate, LocalDate endDate) {
        return cars.values().stream()
                .filter(car -> car.isAvailable() && car.getBrand().equalsIgnoreCase(brand)
                        && car.getModel().equalsIgnoreCase(model))
                .toList();
    }
}
