package repo;

import entities.Doctor;

import javax.print.Doc;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DoctorRepo {
    Map<String, Doctor> doctorMap = new HashMap<>();
    public void addDoctor(String name,String email, String specialization){
        Doctor doctor = new Doctor(name,email,specialization);
        doctorMap.put(doctor.getId(),doctor);
    }
    public Doctor getDoctor(String id){
        return doctorMap.get(id);
    }
    public List<Doctor> getDoctorList(){
        return doctorMap.values().stream().toList();
    }
}
