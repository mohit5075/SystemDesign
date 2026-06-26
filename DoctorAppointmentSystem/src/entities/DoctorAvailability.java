package entities;

import enums.SlotStatus;

import java.util.UUID;

public class DoctorAvailability {
    private String id;
    private Doctor doctor;
    private Slot slot;
    private SlotStatus slotStatus;
    public DoctorAvailability(Doctor doctor,Slot slot){
        this.doctor = doctor;
        this.slot = slot;
        this.slotStatus = SlotStatus.AVAILABLE;
        this.id = doctor.getId()+slot.getSlotId();
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

    public void setSlotStatus(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
