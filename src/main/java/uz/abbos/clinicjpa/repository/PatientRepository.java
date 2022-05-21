package uz.abbos.clinicjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.abbos.clinicjpa.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
