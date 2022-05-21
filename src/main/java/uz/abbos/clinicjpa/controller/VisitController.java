package uz.abbos.clinicjpa.controller;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.abbos.clinicjpa.dto.VisitDto;
import uz.abbos.clinicjpa.entity.Visit;
import uz.abbos.clinicjpa.service.VisitService;

import java.util.List;

@RestController
@RequestMapping("/visit")
public class VisitController {
    @Autowired
    private VisitService visitService;

    @PostMapping
    public ResponseEntity<?> createVisit(@RequestBody VisitDto visitDto){
        boolean result = visitService.createVisit(visitDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getVisit(@PathVariable("id") Integer id){
        VisitDto result = visitService.getVisit(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateVisit(@PathVariable("id") Integer id,
                                           @RequestBody VisitDto visitDto){
        boolean result = visitService.update(id,visitDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVisit(@PathVariable("id") Integer id){
        boolean result = visitService.delete(id);
        return ResponseEntity.ok(result);
    }



    /**Sorting and Pageination*/

    @GetMapping("/field/{field}")
    public ResponseEntity<?> getAllVisitsWithSorting(@PathVariable String field){
        List<Visit> resultAllVisits = visitService.getAllVisitsWithSorting(field);
        return ResponseEntity.ok(resultAllVisits);
    }


    @GetMapping("/pagenation/{offset}/{pageSize}")
    public ResponseEntity<?> getAllWithPagenation(@PathVariable Integer offset,@PathVariable Integer pageSize){
        Page<Visit> resultAllVisits = visitService.getAllVisitWithPagenation(offset,pageSize);
        return ResponseEntity.ok(resultAllVisits);
    }
}
