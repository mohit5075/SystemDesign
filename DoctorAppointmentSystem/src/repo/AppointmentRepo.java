package repo;

import entities.Appointment;
import entities.Doctor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentRepo {
    private Map<String, Appointment> appointmentMap;
    public AppointmentRepo(){
        this.appointmentMap = new HashMap<>();
    }
    public void addAppointment(Appointment appointment){
        appointmentMap.putIfAbsent(appointment.getId(),appointment);
    }
    public Appointment getAppointment(String id){
        return appointmentMap.get(id);
    }
    public List<Appointment> getAllAppointments(){
        return appointmentMap.values().stream().toList();
    }
}
