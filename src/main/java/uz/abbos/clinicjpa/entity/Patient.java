package uz.abbos.clinicjpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surname;
    private LocalDate brithday;
    private String contact;
    private Integer age;
    private boolean status;
    @Column(name = "created_at")
    private LocalDateTime createdAt;



}
