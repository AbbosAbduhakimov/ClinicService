package uz.abbos.clinicjpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "visits")
public class Visit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String diagnosis;
    private boolean status;
    @Column(name = "created_at")
    private LocalDateTime createdAt;



    @ManyToOne
    @JoinColumn(name = ("doctor_id"),insertable = false,updatable = false)
    private Doctor doctor;

    @Column(name = "doctor_id")
    private Integer doctorID;



    @ManyToOne
    @JoinColumn(name = ("patient_id"),insertable = false,updatable = false)
    private Patient patient;

    @Column(name = "patient_id")
    private Integer patientID;






}
