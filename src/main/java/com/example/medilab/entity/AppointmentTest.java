package com.example.medilab.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class AppointmentTest {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String tubeNo;
    private String collectedBy;
    @ManyToOne
    private TestGroup testGroup;
    @ManyToOne
    private Appointment appointments;
    @OneToOne
    private TestReportEntry testReportEntry;

}
