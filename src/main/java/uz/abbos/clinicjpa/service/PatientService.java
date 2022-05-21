package uz.abbos.clinicjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.abbos.clinicjpa.dto.PatientDto;
import uz.abbos.clinicjpa.entity.Patient;
import uz.abbos.clinicjpa.exception.BadRequestException;
import uz.abbos.clinicjpa.repository.PatientRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public boolean createPatient(PatientDto patientDto) {
        Patient patient =  new Patient();
        patient.setName(patientDto.getName());
        patient.setSurname(patientDto.getSurname());
        patient.setContact(patientDto.getContact());
        patient.setCreatedAt(patientDto.getCreatedAt());
        long age = ChronoUnit.YEARS.between(patientDto.getBrithday(),LocalDate.now());
        patient.setAge((int) age);
        patient.setStatus(true);
        patientRepository.save(patient);
        patientDto.setId(patient.getId());
        return true;
    }

    public PatientDto getPatient(Integer id) {
        Patient patient = check(id);
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setAge(patient.getAge());
        patientDto.setContact(patient.getContact());
        patientDto.setBrithday(patient.getBrithday());
        patientDto.setName(patient.getName());
        patientDto.setSurname(patient.getSurname());
        return patientDto;
    }

    public boolean update(Integer id, PatientDto patientDto) {
        Patient patient = check(id);
        patient.setSurname(patientDto.getSurname());
        patient.setName(patientDto.getName());
        patient.setContact(patientDto.getContact());
        patient.setAge(patientDto.getAge());
        patientRepository.save(patient);
        return true;
    }

    public boolean delete(Integer id) {
        Patient patient = check(id);
        patientRepository.delete(patient);
        return true;
    }


    public Patient check(Integer id){
        Optional<Patient> optional = patientRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequestException("patient not found");
        }
        return optional.get();
    }
}
