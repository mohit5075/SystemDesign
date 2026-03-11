package entities;

import enums.AppointmentStatus;

import java.util.UUID;

public class Appointment {
    private String id;
    private String doctorId;
    private String patientId;
    private Slot slot;
    private AppointmentStatus appointmentStatus;

    public Appointment(String doctorId, String patientId, Slot slot, AppointmentStatus appointmentStatus) {
        this.id = UUID.randomUUID().toString();
        this.doctorId = doctorId;
        this.patientId = patientId;
        this.slot = slot;
        this.appointmentStatus = appointmentStatus;
    }

    public AppointmentStatus getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(AppointmentStatus appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }
}
