package strategy;

import entities.Slot;

import java.util.List;

public interface SlotListingStrategy {
    List<Slot> listSlots(List<Slot> slots);
}
