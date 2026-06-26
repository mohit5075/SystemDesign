package strategy;

import entities.Slot;

import java.util.Comparator;
import java.util.List;

public class DefaultListingStrategy implements SlotListingStrategy{
    @Override
    public List<Slot> listSlots(List<Slot> slots) {
        return slots.stream().sorted(Comparator.comparing(Slot::getStartTime)).toList();
    }
}
