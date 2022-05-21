package uz.abbos.clinicjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uz.abbos.clinicjpa.dto.DoctorDto;
import uz.abbos.clinicjpa.entity.Doctor;
import uz.abbos.clinicjpa.exception.BadRequestException;
import uz.abbos.clinicjpa.repository.DoctorRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Transactional
@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public boolean createDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setSurname(doctorDto.getSurname());
        doctor.setContact(doctorDto.getContact());
        doctor.setExperience(doctorDto.getExperience());
        doctor.setCreatedAt(LocalDateTime.now());
        doctor.setDirection(doctor.getDirection());
        doctor.setStatus(true);
        doctorRepository.save(doctor);
        return true;
    }

    public DoctorDto getDoctor(Integer id) {

       Doctor doctor = check(id);
       DoctorDto doctorDto = new DoctorDto();
       doctorDto.setId(doctor.getId());
       doctorDto.setContact(doctor.getContact());
       doctorDto.setDirection(doctor.getDirection());
       doctorDto.setExperience(doctor.getExperience());
       doctorDto.setName(doctor.getName());
       doctorDto.setSurname(doctor.getSurname());
       return doctorDto;
    }

    public boolean update(Integer id, DoctorDto doctorDto) {
        Doctor doctor = check(id);
        doctor.setSurname(doctorDto.getSurname());
        doctor.setName(doctorDto.getName());
        doctor.setDirection(doctorDto.getDirection());
        doctor.setExperience(doctorDto.getExperience());
        doctor.setContact(doctorDto.getContact());
        doctorRepository.save(doctor);
        return true;
    }

    public boolean delete(Integer id) {
        Doctor doctor = check(id);
        doctorRepository.delete(doctor);
        return true;
    }



    public Doctor check(Integer id){
        Optional<Doctor> optional = doctorRepository.findById(id);
        if (optional.isEmpty()){
            throw new BadRequestException("doctor not found");
        }
        return optional.get();
    }
}
