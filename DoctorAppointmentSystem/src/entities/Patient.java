package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Patient {
    private String id;
    private String name;
    private String email;
    private List<Appointment> appointments;

    public Patient(String name, String email) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.appointments = new ArrayList<>();
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

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }

}
