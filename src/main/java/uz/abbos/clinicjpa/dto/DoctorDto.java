package uz.abbos.clinicjpa.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorDto {

    private Integer id;
    @NotBlank(message = ("name must be entered"))
    private String name;

    @NotBlank(message = ("surname must be entered"))
    private String surname;

    @NotBlank(message = ("direction must be entered"))
    private String direction;

    @NotBlank(message = ("contact must be entered"))
    private String contact;

    @NotNull(message = ("experience must be entered"))
    private Integer experience;
    private boolean status;
    private LocalDateTime createdAt;
}
