package uz.abbos.clinicjpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import uz.abbos.clinicjpa.dto.VisitDto;
import uz.abbos.clinicjpa.entity.Visit;
import uz.abbos.clinicjpa.exception.BadRequestException;
import uz.abbos.clinicjpa.repository.VisitRepositroy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VisitService {

    @Autowired
    private VisitRepositroy visitRepositroy;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;




    public boolean createVisit(VisitDto visitDto) {

        Visit visit = new Visit();

        doctorService.check(visitDto.getDoctorID());
        visit.setPatientID(visitDto.getPatientID());

        patientService.check(visitDto.getPatientID());
        visit.setDoctorID(visitDto.getDoctorID());

        visit.setDiagnosis(visitDto.getDiagnosis());
        visit.setCreatedAt(LocalDateTime.now());
        visit.setStatus(true);
        visitRepositroy.save(visit);
        visit.setId(visitDto.getId());
        return true;
    }

    public VisitDto getVisit(Integer id) {
        Visit visit = check(id);
        VisitDto visitDto = new VisitDto();
        visitDto.setDiagnosis(visit.getDiagnosis());
        visitDto.setDoctorDto(doctorService.getDoctor(visit.getId()));
        visitDto.setPatientDto(patientService.getPatient(visit.getId()));
         return visitDto;
    }

    public boolean update(Integer id, VisitDto visitDto) {
        Visit visit = check(id);

        doctorService.check(visitDto.getDoctorID());
        visit.setPatientID(visitDto.getPatientID());

        patientService.check(visitDto.getPatientID());
        visit.setDoctorID(visitDto.getDoctorID());

        visit.setDiagnosis(visitDto.getDiagnosis());
        visitRepositroy.save(visit);
        visit.setId(visitDto.getId());
        return true;
    }

    public boolean delete(Integer id) {
        Visit visit = check(id);
        visitRepositroy.delete(visit);
        return true;
    }



    public Visit check(Integer id){
        Optional<Visit> optional = visitRepositroy.findById(id);
        if (optional.isEmpty()){
            throw new BadRequestException("visit not found");
        }
        return optional.get();
    }

    public List<Visit> getAllVisitsWithSorting(String field) {
        return visitRepositroy.findAll(Sort.by(Sort.Direction.ASC,field));
    }

    // bu dto ga o'girmasdan qilingan usul
//    public Page<Visit> getAllVisitWithPagenation(Integer offset, Integer pageSize) {
//        Page<Visit> visitDtos = visitRepositroy.findAll(PageRequest.of(offset,pageSize));
//        return visitDtos;
//
//    }


    // bu usul dto bilan qilingan usul visitdan dto ga o'girib keyin dto berib yuboramiz xavfsizroq
    public Page<Visit> getAllVisitWithPagenation(Integer offset, Integer pageSize) {
        Pageable pageable = PageRequest.of(offset,pageSize);
        Page<Visit> resultPage = visitRepositroy.findAll(pageable);
        List<VisitDto> response = new ArrayList<>();
        return null;
    }
}
