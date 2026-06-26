package entities;

import enums.Speciality;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Doctor {
    private String id;
    private String name;
    private String email;
    private Speciality speciality;
    private List<Appointment> appointments;

    public Doctor(String name, String email, Speciality speciality) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.speciality = speciality;
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

    public Speciality getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Speciality speciality) {
        this.speciality = speciality;
    }

    public List<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
    }
}
