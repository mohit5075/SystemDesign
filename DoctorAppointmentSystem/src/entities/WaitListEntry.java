package entities;

import java.time.LocalDateTime;

public class WaitListEntry {
    private String id;
    private Doctor doctor;
    private Patient patient;
    private Slot slot;
    private LocalDateTime timestamp;

    public WaitListEntry(Doctor doctor, Patient patient, Slot slot) {
        this.id = doctor.getId()+patient.getId()+slot.getSlotId();
        this.doctor = doctor;
        this.patient = patient;
        this.slot = slot;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
