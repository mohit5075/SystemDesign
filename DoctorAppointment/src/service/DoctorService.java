package service;

import entities.Doctor;
import entities.Slot;
import repo.DoctorRepo;

import javax.print.Doc;
import java.time.LocalDateTime;
import java.util.List;


public class DoctorService {
    private final DoctorRepo doctorRepo;

    public DoctorService(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }
    public List<Doctor> getDoctorsBySpecialization(String specialization){
        return doctorRepo.getDoctorList().stream().filter(doctor ->
            doctor.getSpecialization().equalsIgnoreCase(specialization)).toList();
    }
    public Slot checkDoctorAvailability(String doctorId, LocalDateTime startTime, LocalDateTime endTime){
        Doctor doctor = doctorRepo.getDoctor(doctorId);
        for(Slot slot : doctor.getSlots()){
            if(slot.getStartTime().isEqual(startTime) && slot.getEndTime().isEqual(endTime) && slot.isAvailable()){
                return slot;
            }
        }
        return null;
    }
    public List<Slot> getAvailabilitySlots(String doctorId){
        return doctorRepo.getDoctor(doctorId).getSlots().stream().filter(slot -> slot.isAvailable()).toList();
    }
}
