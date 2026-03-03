package entities;

import enums.BookingStatus;

import java.util.UUID;

public class Booking {
    private String bookingId;
    private String flightId;
    private String passengerId;
    private Payment payment;
    private BookingStatus bookingStatus;
    public Booking(String flightId, String passengerId, Payment payment, BookingStatus bookingStatus) {
        this.bookingId = UUID.randomUUID().toString();
        this.flightId = flightId;
        this.passengerId = passengerId;
        this.payment = payment;
        this.bookingStatus = bookingStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
