package service;

import entities.Appointment;
import entities.Slot;
import enums.AppointmentStatus;
import repo.AppointmentRepo;
import repo.DoctorRepo;
import repo.PatientRepo;

import java.time.LocalDateTime;

public class AppointmentService {
    private final DoctorRepo doctorRepo;
    private final PatientRepo patientRepo;
    private final DoctorService doctorService;
    private final AppointmentRepo appointmentRepo;
    public AppointmentService(DoctorRepo doctorRepo, PatientRepo patientRepo, DoctorService doctorService, AppointmentRepo appointmentRepo) {
        this.doctorRepo = doctorRepo;
        this.patientRepo = patientRepo;
        this.doctorService = doctorService;
        this.appointmentRepo = appointmentRepo;
    }
    public Appointment bookAppointMent(String patientId, String doctorId, LocalDateTime startTime, LocalDateTime endTime){
        Slot slot = doctorService.checkDoctorAvailability(doctorId,startTime,endTime);
        if(slot!=null){
            slot.setAvailable(false);
            Appointment appointment = new Appointment(doctorId,patientId,slot, AppointmentStatus.BOOKED);
            appointmentRepo.addAppointment(appointment);
            return appointment;
        }
        return null;
    }
    public void cancelAppointment(Appointment appointment){
        Slot slot = appointment.getSlot();
        slot.setAvailable(true);
        appointmentRepo.removeAppointment(appointment.getId());
    }
}
