package entities;

import enums.AppointmentStatus;

public class Appointment {
    private String id;
    private Slot slot;
    private Patient patient;
    private Doctor doctor;
    private AppointmentStatus appointmentStatus;

    public Appointment(Slot slot, Patient patient, Doctor doctor) {
        this.slot = slot;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentStatus = AppointmentStatus.BOOKED;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }
}
