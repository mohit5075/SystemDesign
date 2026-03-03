import java.time.LocalDate;
import java.util.Date;

public class Reservation {
    private int id;
    private Car car;
    private LocalDate startDate;
    private LocalDate endDate;
    private Customer customer;
    private int price;
    public Reservation(Car car, LocalDate startDate, LocalDate endDate, Customer customer) {
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
    }
    public Car getCar() {
        return car;
    }
}
