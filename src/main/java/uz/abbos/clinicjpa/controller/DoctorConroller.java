package uz.abbos.clinicjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.abbos.clinicjpa.dto.DoctorDto;
import uz.abbos.clinicjpa.entity.Doctor;
import uz.abbos.clinicjpa.service.DoctorService;

import javax.validation.Valid;


@RestController
@RequestMapping("/doctor")
public class DoctorConroller {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<?> createDoctor(@RequestBody @Valid DoctorDto doctorDto){
        boolean result = doctorService.createDoctor(doctorDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDoctor(@PathVariable("id") Integer id){
        DoctorDto javob = doctorService.getDoctor(id);
        return ResponseEntity.ok(javob);

    }


    @PutMapping("/{id}")
    public ResponseEntity<?> updateDoctor(@PathVariable("id") Integer id,
                                          @RequestBody @Valid  DoctorDto doctorDto){
        boolean result = doctorService.update(id,doctorDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDoctor(@PathVariable("id") Integer id){
        boolean result = doctorService.delete(id);
        return ResponseEntity.ok(result);
    }
}


