package repo;

import entities.Doctor;
import entities.Patient;

import java.util.HashMap;
import java.util.Map;

public class PatientRepo {
    private Map<String, Patient> patientMap;
    public PatientRepo(){
        this.patientMap = new HashMap<>();
    }
    public void addPatient(Patient patient){
        patientMap.putIfAbsent(patient.getId(),patient);
    }
    public Patient getPatient(String id){
        return patientMap.get(id);
    }
}
