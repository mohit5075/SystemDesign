package service;

import entities.*;
import enums.AppointmentStatus;
import enums.SlotStatus;
import enums.Speciality;
import repo.AppointmentRepo;
import repo.DoctorRepo;
import repo.PatientRepo;
import repo.SlotRepo;
import strategy.SlotListingStrategy;

import java.util.*;

public class AppointmentService {
    private final PatientRepo patientRepo;
    private final DoctorRepo doctorRepo;
    private final SlotRepo slotRepo;
    private final AppointmentRepo appointmentRepo;
    private Map<String, DoctorAvailability> doctorAvailabilityMap = new HashMap<>();
    private Map<String,Queue<WaitListEntry>> waitQueueMap;

    public AppointmentService(PatientRepo patientRepo, DoctorRepo doctorRepo, SlotRepo slotRepo, AppointmentRepo appointmentRepo) {
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
        this.slotRepo = slotRepo;
        this.appointmentRepo = appointmentRepo;
        waitQueueMap=new HashMap<>();
    }

    public void registerPatient(String name,String email){
        Patient patient = new Patient(name,email);
        patientRepo.addPatient(patient);
    }

    public void registerDoctor(String name, String email, Speciality speciality){
        Doctor doctor = new Doctor(name, email, speciality);
        doctorRepo.addDoctor(doctor);
    }

    public void addDoctorToSlot(String doctorId,String slotId){
        Doctor doctor = doctorRepo.getDoctor(doctorId);
        Slot slot = slotRepo.getSlot(slotId);
        DoctorAvailability doctorAvailability = new DoctorAvailability(doctor,slot);
        doctorAvailabilityMap.putIfAbsent(doctorAvailability.getId(),doctorAvailability);
    }

    public List<Slot> getSlotsBasedOnSpeciality(Speciality speciality, SlotListingStrategy strategy){
        return doctorAvailabilityMap.values().stream()
                .filter(doctorAvailability -> doctorAvailability.getSlotStatus().equals(SlotStatus.AVAILABLE))
                .filter(doctorAvailability -> doctorAvailability.getDoctor().getSpeciality().equals(speciality))
                .map(DoctorAvailability::getSlot)
                .toList();
    }

    public Appointment bookAppointment(String slotId, String doctorId, String patientId){
        Slot slot = slotRepo.getSlot(slotId);
        Doctor doctor = doctorRepo.getDoctor(doctorId);
        Patient patient = patientRepo.getPatient(patientId);
        DoctorAvailability doctorAvailability = doctorAvailabilityMap.get(doctorId+slotId);
        Appointment appointment = new Appointment(slot,patient,doctor);
        if(!doctorAvailability.getSlotStatus().equals(SlotStatus.AVAILABLE)){
            WaitListEntry waitListEntry = new WaitListEntry(doctor,patient,slot);
            if(waitQueueMap.get(waitListEntry.getId())==null){
                Queue<WaitListEntry> queue = new LinkedList<>();
                waitQueueMap.put(waitListEntry.getId(),queue);
            }
            waitQueueMap.get(waitListEntry.getId()).offer(waitListEntry);
            appointment.setAppointmentStatus(AppointmentStatus.WAITING);
            appointmentRepo.addAppointment(appointment);
            throw new RuntimeException("Slot not available");
        }
        for(Appointment app : patient.getAppointments()){
            if(app.getSlot().equals(slot)){
                throw  new RuntimeException("Already have an booked appointment in that slot");
            }
        }
        appointmentRepo.addAppointment(appointment);
        patient.getAppointments().add(appointment);
        doctor.getAppointments().add(appointment);
        doctorAvailability.setSlotStatus(SlotStatus.BOOKED);
        return appointment;
    }

    public void cancelAppointment(String appointmentId){
        Appointment appointment  = appointmentRepo.getAppointment(appointmentId);
        Patient patient = appointment.getPatient();
        Doctor doctor = appointment.getDoctor();
        Slot slot = appointment.getSlot();
        DoctorAvailability doctorAvailability = doctorAvailabilityMap.get(doctor.getId()+slot.getSlotId());
        if(waitQueueMap.containsKey(doctor.getId()+slot.getSlotId()+patient.getId())){
            String key = doctor.getId()+slot.getSlotId()+patient.getId();
            WaitListEntry waitListEntry = waitQueueMap.get(key).poll();
        }
        doctorAvailability.setSlotStatus(SlotStatus.AVAILABLE);
        appointment.setAppointmentStatus(AppointmentStatus.CANCELED);
    }

    public List<Appointment> getAppointmentForPatient(String patientId){
        Patient patient = patientRepo.getPatient(patientId);
        return patient.getAppointments().stream().filter(appointment -> appointment.getAppointmentStatus().equals(AppointmentStatus.BOOKED)).toList();
    }

    public List<Appointment> getAppointmentForDoctor(String doctorId){
        Doctor doctor = doctorRepo.getDoctor(doctorId);
        return doctor.getAppointments().stream().filter(appointment -> appointment.getAppointmentStatus().equals(AppointmentStatus.BOOKED)).toList();
    }

//    public List<Appointment> getAppointmentsByPatientId(String patientId){
//        Patient patient = patientRepo.getPatient(patientId);
//        return appointmentRepo.getAllAppointments().stream().filter(appointment -> appointment.getPatient().equals(patient)).toList();
//    }
}
