package repo;

import entities.Patient;

import java.util.HashMap;
import java.util.Map;

public class PatientRepo {
    Map<String, Patient> PatientMap = new HashMap<>();
    public void addPatient(String name,String email, String specialization){
        Patient Patient = new Patient(name,email);
        PatientMap.put(Patient.getId(),Patient);
    }
    public Patient getPatient(String id){
        return PatientMap.get(id);
    }
}
