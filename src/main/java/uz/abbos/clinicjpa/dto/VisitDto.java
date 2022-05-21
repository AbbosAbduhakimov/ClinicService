package uz.abbos.clinicjpa.dto;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitDto {

    private Integer id;

    @NotNull
    private String diagnosis;

    private boolean status;
    private LocalDateTime createdAt;



    private DoctorDto doctorDto;

    private Integer doctorID;



    private PatientDto patientDto;

    private Integer patientID;


}
