package repo;

import entities.Slot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SlotRepo {
    private Map<String, Slot> slotMap;
    public SlotRepo(){
        this.slotMap = new HashMap<>();
    }
    public void addSlot(Slot slot){
        slotMap.putIfAbsent(slot.getSlotId(),slot);
    }
    public Slot getSlot(String id){
        return slotMap.get(id);
    }
    public List<Slot> getAllSlots(){
        return slotMap.values().stream().toList();
    }
}
