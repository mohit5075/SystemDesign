package repo;

import entities.Doctor;

import javax.print.Doc;
import java.util.HashMap;
import java.util.Map;

public class DoctorRepo {
    private Map<String, Doctor> doctorMap;
    public DoctorRepo(){
        this.doctorMap = new HashMap<>();
    }
    public void addDoctor(Doctor doctor){
        doctorMap.putIfAbsent(doctor.getId(),doctor);
    }
    public Doctor getDoctor(String id){
        return doctorMap.get(id);
    }
}
