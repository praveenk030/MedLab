package com.example.medilab.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_newappointment")
public class Appointment {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;
    @Column(name = "date_time")
    private LocalDateTime dateAndTime;
    @Column(name = "referred_by")
    private String referredBy;
    @Column(name = "token")
    private String token;
    @Column(name = "appointment_status")
    private String appointmentStatus;
    @Column(name = "no_of_test")
    private Integer noOfTest;
    @Column(name = "no_of_sample_collected")
    private Integer noOfSampleCollection;
    @Column(name = "patient_id")
    private  String patientId;
    @OneToMany(mappedBy = "appointments")
    private List<AppointmentTest> appointmentTests;
}
