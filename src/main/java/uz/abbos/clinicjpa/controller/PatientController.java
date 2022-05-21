package uz.abbos.clinicjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.abbos.clinicjpa.dto.PatientDto;
import uz.abbos.clinicjpa.service.PatientService;

import javax.validation.Valid;

@RestController
@RequestMapping("/patient")
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<?> createPatinet(@RequestBody @Valid PatientDto patientDto){
        boolean result = patientService.createPatient(patientDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatient(@PathVariable("id") Integer id){
        PatientDto result = patientService.getPatient(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePatient(@PathVariable("id") Integer id,
                                           @RequestBody PatientDto patientDto){
        boolean result = patientService.update(id,patientDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable("id") Integer id){
        boolean result = patientService.delete(id);
        return ResponseEntity.ok(result);
    }
}
