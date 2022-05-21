package uz.abbos.clinicjpa.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PatientDto {

    private Integer id;

    @NotNull
    private String name;

    @NotBlank(message = ("familyani  kirit shart"))
    @NotEmpty(message = ("bo'sh bo'masin"))
    private String surname;

    @NotNull
    private LocalDate brithday;

    @NotNull
    private String contact;


    private Integer age;

    private boolean status;

    private LocalDateTime createdAt;
}
