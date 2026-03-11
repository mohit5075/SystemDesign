package repo;

import entities.Appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentRepo {
    private Map<String, Appointment> appointmentMap = new HashMap<>();
    public void addAppointment(Appointment appointment){
        appointmentMap.put(appointment.getId(),appointment);
    }
    public Appointment getAppointment(String appointmentId){
        return appointmentMap.get(appointmentId);
    }
    public void removeAppointment(String appointmentId){
        appointmentMap.remove(appointmentId);
    }
}
