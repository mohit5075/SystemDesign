package entities;

import java.util.List;
import java.util.UUID;

public class Doctor {
    private String id;
    private String name;
    private String email;
    private String specialization;
    private List<Slot> slots;

    public Doctor(String name, String email, String specialization) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.specialization = specialization;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getSpecialization() {
        return specialization;
    }
    public void addSlot(Slot slot){
        slots.add(slot);
    }
    public List<Slot> getSlots(){
        return slots;
    }
}
