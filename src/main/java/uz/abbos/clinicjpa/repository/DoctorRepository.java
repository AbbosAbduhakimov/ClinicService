package uz.abbos.clinicjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.abbos.clinicjpa.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
